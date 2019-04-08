package com.client.system.mapper;

import com.client.system.model.Menus;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface MenusMapper extends Mapper<Menus> {
    @Override
    List<Menus> selectAll();
}
