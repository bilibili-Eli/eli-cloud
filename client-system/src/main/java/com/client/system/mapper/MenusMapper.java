package com.client.system.mapper;

import com.client.system.model.Menus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MenusMapper extends Mapper<Menus> {
    @Override
    List<Menus> selectAll();

    List<Menus> selectMenus(@Param(value = "userId") String userId);

    List<Menus> selectChildAndParent(Menus menus);
}
