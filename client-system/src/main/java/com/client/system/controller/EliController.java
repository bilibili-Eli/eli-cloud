package com.client.system.controller;

import com.client.system.model.EliApiResult;
import com.client.system.util.EliControllerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @param <Service> 所使用的service接口
 * @param <Model>   所使用的实体类
 * @param <Vo>      所使用的实体扩展类
 * @author eli
 * <p>
 * 公用Controller，默认实现增删改查接口
 */
public class EliController<Service, Model, Vo extends Model> {
    /**
     * Service接口
     */
    @Autowired
    Service impl;

    /**
     * Controller工具类
     */
    @Resource(name = "eliControllerUtil")
    protected EliControllerUtil<Service, Model> util;

    /**
     * 查询全部
     *
     * @param model 实体类
     * @return 通用返回类
     */
    @RequestMapping(value = "selectAll", method = RequestMethod.POST)
    public EliApiResult selectAll(@RequestBody Model model, HttpServletRequest request) {
        return util.invoke(EliControllerUtil.SELECT_ALL, impl, model, request);
    }

    /**
     * 新增数据
     *
     * @param vo 扩展类
     * @return 通用返回类
     */
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public EliApiResult insert(@RequestBody Vo vo, HttpServletRequest request) {
        return util.invoke(EliControllerUtil.INSERT, impl, vo, request);
    }

    /**
     * 更新方法
     *
     * @param vo 实体类，id必须
     * @return 通用返回类
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public EliApiResult update(@RequestBody Vo vo, HttpServletRequest request) {
        return util.invoke(EliControllerUtil.UPDATE, impl, vo, request);
    }

    /**
     * 删除方法
     *
     * @param model 实体类，id必须
     * @return 通用返回类
     */
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public EliApiResult delete(@RequestBody Model model, HttpServletRequest request) {
        return util.invoke(EliControllerUtil.DELETE, impl, model, request);
    }

    /**
     * 根据id查询详情方法
     *
     * @param model 实体类，id必须
     * @return 通用返回类
     */
    @RequestMapping(value = "selectById", method = RequestMethod.POST)
    public EliApiResult selectById(@RequestBody Model model, HttpServletRequest request) {
        return util.invoke(EliControllerUtil.SELECT_BY_ID, impl, model, request);
    }

    /**
     * 条件查询
     *
     * @param model 实体类
     * @return 通用返回类
     */
    @RequestMapping(value = "select", method = RequestMethod.POST)
    public EliApiResult select(@RequestBody Model model, HttpServletRequest request) {
        return util.invoke(EliControllerUtil.SELECT, impl, model, request);
    }
}
