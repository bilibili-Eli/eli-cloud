package com.client.system.service;

import com.client.system.exception.EliException;
import com.client.system.model.Menus;
import com.client.system.vo.MenusVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MenusService extends EliService<Menus, MenusVo> {
    List<Menus> selectByUser(Menus menus, HttpServletRequest request) throws EliException;

    List<Menus> selectChildAndParent(Menus menus, HttpServletRequest request) throws EliException;
}
