package com.client.system.controller;

import com.client.system.model.EliApiResult;
import com.client.system.model.Sql;
import com.client.system.service.SqlService;
import com.client.system.vo.SqlVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("sql")
@RestController
public class SqlController extends EliController<SqlService, Sql, SqlVo> {

    @RequestMapping("selectSchemata")
    public EliApiResult selectSchemata(@RequestBody(required = false) Sql sql, HttpServletRequest request) {
        return util.invoke("selectSchemata", impl, sql, request);
    }
}
