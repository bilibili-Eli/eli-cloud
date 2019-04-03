package com.client.system.service;

import com.client.system.exception.EliException;
import com.client.system.model.Dictionary;
import com.client.system.vo.DictionaryVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface DictionaryService extends EliService<Dictionary, DictionaryVo> {
    List<Dictionary> selectChildrenByName(Dictionary model, HttpServletRequest request) throws EliException;
}
