package com.client.system.service.impl;

import com.client.system.enums.EliApiCode;
import com.client.system.exception.EliException;
import com.client.system.mapper.MenusMapper;
import com.client.system.model.Menus;
import com.client.system.service.MenusService;
import com.client.system.vo.MenusVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service
public class MenusServiceImpl extends BaseRedisServiceImpl<String> implements MenusService {

    @Resource
    private MenusMapper menusMapper;

    @Override
    public void insert(MenusVo menusVo, HttpServletRequest request) throws EliException {
        try {
            menusVo.setMenuId(UUID.randomUUID().toString());
            menusVo.iniInsert(request, hashOperations);
            menusMapper.insert(menusVo);
        } catch (Exception e) {
            throw new EliException(EliApiCode.SYSTEM_INNER_ERROR);
        }
    }

    @Override
    public void update(MenusVo menusVo, HttpServletRequest request) throws EliException {
        try {
            menusVo.iniModify(request, hashOperations);
            menusMapper.updateByPrimaryKeySelective(menusVo);
        } catch (Exception e) {
            throw new EliException(EliApiCode.SYSTEM_INNER_ERROR);
        }
    }

    @Override
    public void delete(Menus model, HttpServletRequest request) throws EliException {
        try {
            menusMapper.delete(model);
        } catch (Exception e) {
            throw new EliException(EliApiCode.SYSTEM_INNER_ERROR);
        }
    }

    @Override
    public Menus selectById(Menus model, HttpServletRequest request) throws EliException {
        try {
            return menusMapper.selectByPrimaryKey(model.getMenuId());
        } catch (Exception e) {
            throw new EliException(EliApiCode.SYSTEM_INNER_ERROR);
        }
    }

    @Override
    public List<Menus> selectAll(Menus model, HttpServletRequest request) throws EliException {
        try {
            return menusMapper.selectAll();
        } catch (Exception e) {
            throw new EliException(EliApiCode.SYSTEM_INNER_ERROR);
        }
    }

    @Override
    public List<Menus> select(Menus model, HttpServletRequest request) throws EliException {
        try {
            return menusMapper.select(model);
        } catch (Exception e) {
            throw new EliException(EliApiCode.SYSTEM_INNER_ERROR);
        }
    }

    @Override
    public List<Menus> selectByUser(Menus menus, HttpServletRequest request) throws EliException {
        try {
            return menusMapper.selectMenus(get(request.getHeader("user-token")));
        } catch (Exception e) {
            throw new EliException(EliApiCode.SYSTEM_INNER_ERROR);
        }
    }
}
