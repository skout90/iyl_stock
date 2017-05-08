package com.iyl.stock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.iyl.stock.mapper.GenericMapper;

/**
 * <pre>
 * Class Name  : GenericService.java
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
public class GenericService<M extends GenericMapper<R, P>, R, P> {
    protected Logger log;
    protected M mapper;

    public GenericService() {
        this.log = LoggerFactory.getLogger(super.getClass());
    }

    @Autowired
    protected void setMapper(M mapper) {
        this.mapper = mapper;
    }

    public List<R> selectAllList() throws Exception {
        return this.mapper.selectAllList();
    }

    public List<R> selectAllList(P paramVo) throws Exception {
        return this.mapper.selectAllList(paramVo);
    }

    public List<R> selectList(P paramVo) throws Exception {
        return this.mapper.selectList(paramVo);
    }

    public R select(P paramVo) throws Exception {
        return this.mapper.select(paramVo);
    }

    public int selectTotalCount(P paramVo) throws Exception {
        return this.mapper.selectTotalCount(paramVo);
    }

    public void insert(P paramVo) throws Exception {
        this.mapper.insert(paramVo);
    }

    public void update(P paramVo) throws Exception {
        this.mapper.update(paramVo);
    }

    public void delete(P paramVo) throws Exception {
        this.mapper.delete(paramVo);
    }
}
