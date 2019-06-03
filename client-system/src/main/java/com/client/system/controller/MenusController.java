package com.client.system.controller;

import com.client.system.model.EliApiResult;
import com.client.system.model.Menus;
import com.client.system.service.MenusService;
import com.client.system.vo.MenusVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("menus")
public class MenusController extends EliController<MenusService, Menus, MenusVo> {
    /**
     * 根据用户所在角色查询（还在开发）
     *
     * @param menus   条件
     * @param request request域
     * @return 用户权限所属目录
     */
    @RequestMapping("selectByUser")
    public EliApiResult selectByUser(@RequestBody Menus menus, HttpServletRequest request) {
        return util.invoke("selectByUser", impl, menus, request);
    }

    /**
     * 查询父类以及对应子类
     *
     * @param menus   条件
     * @param request request域
     * @return 子父集合
     */
    @RequestMapping("selectChildAndParent")
    public EliApiResult selectChildAndParent(@RequestBody Menus menus, HttpServletRequest request) {
        return util.invoke("selectChildAndParent", impl, menus, request);
    }

    @RequestMapping("lalala")
    public Map<String, Object> lalala(@RequestBody InnerParams innerParams) {
        System.out.println(innerParams);
        return null;
    }
}

class InnerParams{
    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
