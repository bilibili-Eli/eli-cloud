package com.client.system.service.impl;

import com.client.system.enums.EliApiCode;
import com.client.system.exception.EliException;
import com.client.system.mapper.SqlMapper;
import com.client.system.model.Schemata;
import com.client.system.model.Sql;
import com.client.system.service.SqlService;
import com.client.system.vo.SchemataVo;
import com.client.system.vo.SqlVo;
import com.client.system.vo.TableVo;
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
    public List<Map<String, Object>> select(Sql sql, HttpServletRequest request) throws EliException {
        try {
            return sqlMapper.select(sql);
        } catch (Exception e) {
            throw new EliException(EliApiCode.SQL_EXCEPTION);
        }
    }

    @Override
    public void update(SqlVo sqlVo, HttpServletRequest request) throws EliException {
        try {
            sqlMapper.update(sqlVo);
        } catch (Exception e) {
            throw new EliException(EliApiCode.SQL_EXCEPTION);
        }
    }

    @Override
    public void insert(SqlVo sqlVo, HttpServletRequest request) throws EliException {
        try {
            sqlMapper.insert(sqlVo);
        } catch (Exception e) {
            throw new EliException(EliApiCode.SQL_EXCEPTION);
        }
    }

    @Override
    public void delete(Sql sql, HttpServletRequest request) throws EliException {
        try {
            sqlMapper.delete(sql);
        } catch (Exception e) {
            throw new EliException(EliApiCode.SQL_EXCEPTION);
        }
    }

    @Override
    public List<SchemataVo> selectSchemata(Sql sql, HttpServletRequest request) throws EliException {
        try {
            return sqlMapper.selectSchemata();
        } catch (Exception e) {
            throw new EliException(EliApiCode.SQL_EXCEPTION);
        }
    }

    @Override
    public TableVo selectColumnByTable(SqlVo sqlVo, HttpServletRequest request) throws EliException {
        try {
            return sqlMapper.selectColumnByTable(sqlVo);
        } catch (Exception e) {
            throw new EliException(EliApiCode.SQL_EXCEPTION);
        }
    }
}
