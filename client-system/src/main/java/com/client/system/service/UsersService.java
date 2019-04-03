package com.client.system.service;

import com.client.system.exception.EliException;
import com.client.system.model.EliApiResult;
import com.client.system.model.Users;
import com.client.system.vo.UsersVo;

import javax.servlet.http.HttpServletRequest;

public interface UsersService extends EliService<Users, UsersVo> {
    /**
     * 登录
     *
     * @param users   用户实体
     * @param request request域
     * @return 用户扩展实体
     */
    EliApiResult login(Users users, HttpServletRequest request) throws EliException;

    /**
     * 退出登录
     *
     * @param request request域
     * @return 用户扩展实体
     */
    EliApiResult logout(HttpServletRequest request) throws EliException;
}
