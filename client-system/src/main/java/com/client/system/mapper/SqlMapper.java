package com.client.system.mapper;

import com.client.system.model.Sql;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SqlMapper {
    List<Map<String, Object>> select(Sql sql);

    void update(Sql sql);

    void insert(Sql sql);

    void delete(Sql sql);
}
