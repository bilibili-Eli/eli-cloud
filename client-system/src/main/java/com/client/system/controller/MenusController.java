package com.client.system.controller;

import com.client.system.model.EliApiResult;
import com.client.system.model.Menus;
import com.client.system.service.MenusService;
import com.client.system.vo.MenusVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("menus")
public class MenusController extends EliController<MenusService, Menus, MenusVo> {
    @RequestMapping("selectByUser")
    public EliApiResult selectByUser(Menus menus, HttpServletRequest request) {
        return util.invoke("selectByUser", impl, menus, request);
    }
}
