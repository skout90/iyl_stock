package com.iyl.stock.mapper;

import com.iyl.stock.common.DataMap;
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
public interface ScheduleMapper extends GenericMapper<DataMap, ScheduleVo> {

    /**
     * @Author 남준호
     * @Comment 최근 공시 스케줄 정보를 리턴합니다.
     * @param scheduleVo
     * @throws Exception
     */
    public DataMap selectLast() throws Exception;

}
