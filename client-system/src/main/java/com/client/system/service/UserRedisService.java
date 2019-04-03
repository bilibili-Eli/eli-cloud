package com.client.system.service;

import com.client.system.exception.EliException;
import com.client.system.model.Users;

import java.util.List;

public interface UserRedisService {
    /**
     * 查询当前在线用户
     *
     * @return 在线用户
     */
    List<Users> selectAll() throws EliException;

    /**
     * 清空当前在线用户
     */
    void deleteAll() throws EliException;

}
