package com.client.system.service;

import com.client.system.exception.EliException;
import com.client.system.model.Sql;
import com.client.system.vo.SqlVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface SqlService {
    List<Map<String, Object>> select(Sql sql, HttpServletRequest request) throws EliException;

    void update(SqlVo sqlVo, HttpServletRequest request) throws EliException;

    void insert(SqlVo sqlVo, HttpServletRequest request) throws EliException;

    void delete(Sql sql, HttpServletRequest request) throws EliException;
}
