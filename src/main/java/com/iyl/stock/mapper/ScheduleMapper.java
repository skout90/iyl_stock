package com.iyl.stock.mapper;

import java.util.List;

import com.iyl.stock.vo.ScheduleVo;

/**
 * <pre>
 * Class Name  : ScheduleMapper.java
 * Description : 스케줄 매퍼
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
public interface ScheduleMapper {
    /**
     * @Author 남준호
     * @Comment 스케줄 정보 리스트를 리턴합니다.
     * @param scheduleVo
     * @return
     * @throws Exception
     */
    public List<ScheduleVo> selectList(ScheduleVo scheduleVo) throws Exception;

    /**
     * @Author 남준호
     * @Comment 최근 공시 스케줄 정보를 리턴합니다.
     * @param scheduleVo
     * @throws Exception
     */
    public ScheduleVo select() throws Exception;

    /**
     * @Author 남준호
     * @Comment 공시 스케줄 정보를 입력합니다.
     * @param scheduleVo
     * @throws Exception
     */
    public void insert(ScheduleVo scheduleVo) throws Exception;
}
