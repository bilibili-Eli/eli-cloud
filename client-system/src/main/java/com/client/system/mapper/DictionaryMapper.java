package com.client.system.mapper;

import com.client.system.model.Dictionary;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface DictionaryMapper extends Mapper<Dictionary> {
    @Override
    List<Dictionary> selectAll();

    List<Dictionary> selectChildrenByName(Dictionary dictionary);
}
