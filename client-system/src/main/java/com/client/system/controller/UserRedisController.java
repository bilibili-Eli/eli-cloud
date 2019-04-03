package com.client.system.controller;

import com.client.system.exception.EliException;
import com.client.system.model.EliApiResult;
import com.client.system.service.UserRedisService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * redis状态管理器
 */
@RestController
@RequestMapping("users/redis")
public class UserRedisController {

    @Resource
    private UserRedisService userRedisServiceImpl;

    /**
     * 获取当前在线用户
     *
     * @return EliApiResult
     */
    @RequestMapping(value = "selectAll", method = RequestMethod.POST)
    public EliApiResult selectAll() {
        try {
            return EliApiResult.success("获取成功", userRedisServiceImpl.selectAll());
        } catch (EliException e) {
            return EliApiResult.fail(e.message());
        }
    }

    /**
     * 清空在线用户（踢下线）
     *
     * @return EliApiResult
     */
    @RequestMapping(value = "deleteAll", method = RequestMethod.DELETE)
    public EliApiResult deleteAll() {
        try {
            userRedisServiceImpl.deleteAll();
            return EliApiResult.success("清除成功");
        } catch (EliException e) {
            return EliApiResult.fail(e.message());
        }
    }
}
