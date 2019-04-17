package com.client.system.controller;

import com.client.system.model.Sql;
import com.client.system.service.SqlService;
import com.client.system.vo.SqlVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("sql")
@RestController
public class SqlController extends EliController<SqlService, Sql, SqlVo> {

}
