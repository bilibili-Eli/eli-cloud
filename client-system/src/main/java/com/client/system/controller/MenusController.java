package com.client.system.controller;

import com.client.system.model.Menus;
import com.client.system.service.MenusService;
import com.client.system.vo.MenusVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menus")
public class MenusController extends EliController<MenusService, Menus, MenusVo> {
}
