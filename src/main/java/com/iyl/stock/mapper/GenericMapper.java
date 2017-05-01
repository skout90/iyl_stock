package com.iyl.stock.mapper;

import java.util.List;

/**
 * <pre>
 * Class Name  : GenericMapper.java
 * Description : 
 * Modification Information
 *
 *    수정일　　　 　　  수정자　　　     수정내용
 *    ────────────   ─────────   ───────────────────────────────
 *    2017. 5. 1.   남준호              최초생성
 * </pre>
 *
 * @author 남준호
 * @since 2017. 5. 1.
 * @version 1.0
 *
 * Copyright (C) 2017 by IYL All right reserved.
 */
public abstract interface GenericMapper<R, P> {

    public abstract List<R> selectAllList() throws Exception;

    public abstract List<R> selectAllList(P paramP) throws Exception;

    public abstract List<R> selectList(P paramP) throws Exception;

    public abstract R select(P paramP) throws Exception;

    public abstract int selectTotalCount(P paramP) throws Exception;

    public abstract void insert(P paramP) throws Exception;

    public abstract void update(P paramP) throws Exception;

    public abstract void delete(P paramP) throws Exception;
}
