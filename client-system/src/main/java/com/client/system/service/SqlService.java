package com.client.system.service;

import com.client.system.model.Sql;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface SqlService {
    List<Map<String, Object>> select(Sql sql, HttpServletRequest request);
}
