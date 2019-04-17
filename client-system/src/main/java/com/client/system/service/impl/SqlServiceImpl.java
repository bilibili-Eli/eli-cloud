package com.client.system.service.impl;

import com.client.system.mapper.SqlMapper;
import com.client.system.model.Sql;
import com.client.system.service.SqlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class SqlServiceImpl implements SqlService {
    @Resource
    private SqlMapper sqlMapper;


    @Override
    public List<Map<String, Object>> select(Sql sql, HttpServletRequest request) {
        return sqlMapper.select(sql);
    }
}
