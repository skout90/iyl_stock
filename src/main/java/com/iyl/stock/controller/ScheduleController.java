package com.iyl.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyl.stock.service.ScheduleService;
import com.iyl.stock.vo.ScheduleVo;

/**
 * <pre>
 * Class Name  : ScheduleController.java
 * Description : 스케줄 컨트롤러
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
@RequestMapping(value = "/schedule")
@RestController
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    //    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    /**
     * @Author 남준호
     * @Comment 스케줄 리스트를 리턴합니다.
     * @param scheduleVo
     * @return
     */
    @RequestMapping(value = "list")
    public void selectScheduleList(ScheduleVo scheduleVo) throws Exception {
        this.scheduleService.selectList(scheduleVo);
    }

    /**
     * @Author 남준호
     * @Comment 최근 공시 푸시 발송
     * @param scheduleVo
     * @return
     */
    @RequestMapping(value = "insertSchedulePush")
    public void insertSchedulePush(ScheduleVo scheduleVo) throws Exception {
        this.scheduleService.insertPush();
    }
}
