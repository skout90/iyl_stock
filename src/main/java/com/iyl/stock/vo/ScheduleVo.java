package com.iyl.stock.vo;

import java.util.Date;

/**
 * <pre>
 * Class Name  : ScheduleVo.java
 * Description : 스케줄 Vo
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
@lombok.Getter
@lombok.Setter
public class ScheduleVo {
    // 일련번호
    Integer seqno;
    // 최근 접수 코드
    String lastRcpNo;
    // 제목
    String title;
    // 내용
    String contents;
    // 등록 일시
    Date regDt;
}
