package com.iyl.stock.service;

import org.springframework.stereotype.Service;

import com.iyl.stock.common.DataMap;
import com.iyl.stock.mapper.UserMapper;
import com.iyl.stock.vo.UserVo;

/**
 * <pre>
 * Class Name  : UserService.java
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
@Service
public class UserService extends GenericService<UserMapper, DataMap, UserVo> {

    /**
     * @Author 남준호
     * @Comment 디바이스 토큰값을 입력합니다.
     * @param userVo
     * @throws Exception
     */
    @Override
    public void insert(UserVo userVo) throws Exception {
        if (this.mapper.select(userVo) == null) {
            super.insert(userVo);
        }
    }
}
