package com.iyl.stock.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iyl.stock.common.DataMap;
import com.iyl.stock.mapper.ScheduleMapper;
import com.iyl.stock.vo.ScheduleVo;
import com.iyl.stock.vo.UserVo;

import net.sf.json.JSONObject;

/**
 * <pre>
 * Class Name  : ScheduleService.java
 * Description : 스케줄 서비스
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 3. 24.   남준호              최초생성
 * </pre>
 *
 * @author 남준호
 * @since 2017. 3. 24.
 * @version 1.0
 *
 * Copyright (C) 2017 by MyHeart All right reserved.
 */
@Service
public class ScheduleService extends GenericService<ScheduleMapper, DataMap, ScheduleVo> {

    @Resource(name = "apiProp")
    private Properties apiProp;

    @Autowired
    private UserService userService;

    private static final String API_DART_URL = "http://dart.fss.or.kr/api/search.json?auth=";
    private static final String REPORT_URL = "http://m.dart.fss.or.kr/html_mdart/MD1007.html?rcpNo=";
    private static final Integer DEFAULT_PAGE_SIZE = 100;

    private static final String API_PUSH_URL = "https://fcm.googleapis.com/fcm/send";

    @Override
    public void insert(ScheduleVo scheduleVo) throws Exception {
        // 마지막 접수 번호를 확인합니다.
        String beforelastRcpNo = null;
        DataMap lastRcpMap = this.selectLast();
        if (lastRcpMap != null) {
            beforelastRcpNo = (String) lastRcpMap.get("lastRcpNo");
        }
        String newLastRcpNo = "";
        String contents = "";
        String title = " 외";
        String key = (String) this.apiProp.get("api.dart.key");
        String requestUrl = String.format(API_DART_URL + "%s&page_set=%d", key, DEFAULT_PAGE_SIZE);
        //        String requestUrl = String.format(API_URL + "%s&page_set=%d&end_dt=20170428", key, DEFAULT_PAGE_SIZE);

        URLConnection connection = new URL(requestUrl).openConnection();
        JsonNode root = new ObjectMapper().readValue(connection.getInputStream(), JsonNode.class);

        JsonNode contactNode = root.path("list");
        for (JsonNode node : contactNode) {
            if (beforelastRcpNo != null && beforelastRcpNo.equals(node.path("rcp_no").asText())) {
                // 마지막 등록했던 접수 번호전까지 입력
                break;
            }
            if (StringUtils.isEmpty(newLastRcpNo)) {
                // 최신 접수 번호 등록
                newLastRcpNo = node.path("rcp_no").asText();
                title = node.path("crp_nm").asText() + title;
            }

            contents += String
                    .format("<a href='%s'>[%s]</a><br/>%s<br/><br/>", REPORT_URL + node.path("rcp_no").asText(), node.path("crp_nm").asText(), node.path("rpt_nm").asText());
            log.debug(contents);
        }

        // 새로 등록된 공시 정보가 있을시
        if (StringUtils.isNotEmpty(newLastRcpNo)) {
            ScheduleVo paramVo = new ScheduleVo();
            paramVo.setLastRcpNo(newLastRcpNo);
            paramVo.setTitle(title);
            paramVo.setContents(contents);
            super.insert(paramVo);

            // 푸시 발송
            this.insertPush(title);
        }
    }

    /**
     * @Author 남준호
     * @Comment 푸시 스케줄 정보를 입력합니다.
     * @param scheduleVo
     * @return
     * @throws Exception
     */
    public void insertPush(String message) throws Exception {
        // Create connection to send FCM Message request.
        URL url = new URL(API_PUSH_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("Authorization", "key=" + apiProp.getProperty("google.fcm.key"));
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);

        OutputStream outputStream = conn.getOutputStream();

        // 메시지 설정
        JSONObject messageObject = new JSONObject();
        messageObject.put("title", "IYLS 공시현황");
        messageObject.put("message", message);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", messageObject.toString());

        // 푸시전송
        for (DataMap result : this.userService.selectList(new UserVo())) {
            jsonObject.put("to", result.get("deviceToken"));

            // Send FCM message content.
            outputStream.write(jsonObject.toString().getBytes());

            this.log.debug(String.valueOf(conn.getResponseCode()));
            this.log.debug(conn.getResponseMessage());
        }
    }

    /**
     * @Author 남준호
     * @Comment 최근 공시 스케줄 정보를 리턴합니다.
     * @param scheduleVo
     * @throws Exception
     */
    public DataMap selectLast() throws Exception {
        return this.mapper.selectLast();
    }

}
