package com.iyl.stock.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iyl.stock.service.ScheduleService;

/**
 * <pre>
 * Class Name  : ScheduleJob.java
 * Description : 스케줄 잡 정의
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 3. 30.   남준호              최초생성
 * </pre>
 *
 * @author 남준호
 * @since 2017. 3. 30.
 * @version 1.0
 *
 * Copyright (C) 2017 by KHSA All right reserved.
 */
@Component
public class Schedule {

    @Autowired
    private ScheduleService scheduleService;

    public void executeJob() throws Exception {
        this.scheduleService.insertPush();
    }
}
