package com.iyl.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyl.stock.service.UserService;
import com.iyl.stock.vo.UserVo;

/**
 * <pre>
 * Class Name  : UserController.java
 * Description : 회원 컨트롤러
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
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Author 남준호
     * @Comment 사용자 정보를 입력합니다.
     * @throws Exception
     */
    @RequestMapping("insert")
    public void insertUser(UserVo userVo) throws Exception {
        // 토큰값 입력
        this.userService.insert(userVo);
    }
}
