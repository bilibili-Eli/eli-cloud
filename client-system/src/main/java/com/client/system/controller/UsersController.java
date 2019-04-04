package com.client.system.controller;

import com.client.system.exception.EliException;
import com.client.system.model.EliApiResult;
import com.client.system.model.Users;
import com.client.system.service.UsersService;
import com.client.system.enums.EliApiCode;
import com.client.system.vo.UsersVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户类接口
 */
@RestController
@RequestMapping("users")
public class UsersController extends EliController<UsersService, Users, UsersVo> {
    /**
     * 登录方法
     *
     * @param users   存储用户名密码
     * @param request request域
     * @return 用户token及详情
     */
    @RequestMapping("login")
    public EliApiResult login(@RequestBody Users users, HttpServletRequest request) {
        try {
            if (users == null) {
                return EliApiResult.fail(EliApiCode.PARAMS_IS_INVALID);
            }
            return impl.login(users, request);
        } catch (EliException e) {
            return EliApiResult.fail(e.getCode() + "：" + e.getMessage());
        }
    }

    /**
     * 查询用户详情方法
     *
     * @param token   用户token
     * @param request request域
     * @return 用户token及详情
     */
    @RequestMapping("info")
    public EliApiResult info(@RequestHeader(name = "user-token") String token, HttpServletRequest request) {
        Map<String, List> admin = new HashMap<>();
        List<String> roles = new ArrayList<>();
        roles.add("vip");
        admin.put("roles", roles);
        return EliApiResult.success(admin);
    }

    /**
     * 退出登录
     *
     * @param request request域
     * @return 用户token及详情
     */
    @RequestMapping("logout")
    public EliApiResult logout(HttpServletRequest request) {
        try {
            return impl.logout(request);
        } catch (EliException e) {
            return EliApiResult.fail(e.getCode() + "：" + e.getMessage());
        }
    }
}
