package com.client.system.service.impl;

import com.client.system.exception.EliException;
import com.client.system.mapper.DictionaryMapper;
import com.client.system.model.Dictionary;
import com.client.system.service.DictionaryService;
import com.client.system.vo.DictionaryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Service
public class DictionaryServiceImpl extends BaseRedisServiceImpl<String> implements DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Override
    public void insert(DictionaryVo dictionaryVo, HttpServletRequest request) {
        dictionaryVo.setDictionaryId(UUID.randomUUID().toString());
        dictionaryVo.iniInsert(request, hashOperations);
        dictionaryMapper.insertSelective(dictionaryVo);
    }

    @Override
    public void update(DictionaryVo dictionaryVo, HttpServletRequest request) {
        dictionaryVo.iniModify(request, hashOperations);
        dictionaryMapper.updateByPrimaryKeySelective(dictionaryVo);
    }

    @Override
    public void delete(Dictionary dictionary, HttpServletRequest request) {
        dictionaryMapper.delete(dictionary);
    }

    @Override
    public Dictionary selectById(Dictionary dictionary, HttpServletRequest request) {
        return dictionaryMapper.selectOne(dictionary);
    }

    @Override
    public List<Dictionary> selectAll(Dictionary model, HttpServletRequest request) {
        return dictionaryMapper.selectAll();
    }

    @Override
    public List<Dictionary> select(Dictionary model, HttpServletRequest request) {
        return dictionaryMapper.select(model);
    }

    @Override
    public List<Dictionary> selectChildrenByName(Dictionary model, HttpServletRequest request) throws EliException {
        return dictionaryMapper.selectChildrenByName(model);
    }
}
