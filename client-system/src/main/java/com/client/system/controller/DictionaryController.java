package com.client.system.controller;

import com.client.system.exception.EliException;
import com.client.system.model.Dictionary;
import com.client.system.model.EliApiResult;
import com.client.system.service.DictionaryService;
import com.client.system.util.EliApiCode;
import com.client.system.vo.DictionaryVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("dictionary")
public class DictionaryController extends EliController<DictionaryService, Dictionary, DictionaryVo> {
    @RequestMapping("selectChildrenByName")
    public EliApiResult selectChildrenByName(@RequestBody Dictionary dictionary, HttpServletRequest request) {
        if (dictionary == null) {
            return EliApiResult.fail(EliApiCode.PARAMS_IS_INVALID);
        }
        try {
            return EliApiResult.success("获取成功", impl.selectChildrenByName(dictionary, request));
        } catch (EliException e) {
            return EliApiResult.fail(e.message());
        }
    }
}
