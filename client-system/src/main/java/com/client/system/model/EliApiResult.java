package com.client.system.model;

import com.client.system.enums.EliApiCode;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author eli
 * 通用工具返回类
 */
public class EliApiResult {
    private int code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    public EliApiResult() {
        this.setCode(EliApiCode.SUCCESS);
    }

    public EliApiResult(EliApiCode eliApiCode) {
        this(eliApiCode.getCode(), eliApiCode.getMsg(), null);
    }

    public EliApiResult(EliApiCode eliApiCode, Object data) {
        this(eliApiCode.getCode(), eliApiCode.getMsg(), data);
    }

    public EliApiResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public EliApiResult(Object data) {
        this.data = data;
    }

    public void setCustomerMsg(String msg) {
        this.code = -1;
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCode(EliApiCode eliApiCode) {
        this.code = eliApiCode.getCode();
        if (this.code == 0) this.msg = eliApiCode.getMsg();
        else this.msg = eliApiCode.getCode() + "：" + eliApiCode.getMsg();
    }

    public static EliApiResult fail(String msg) {
        EliApiResult EliApiResult = new EliApiResult();
        EliApiResult.setCustomerMsg(msg);
        return EliApiResult;
    }

    public static EliApiResult fail(EliApiCode eliApiCode) {
        EliApiResult EliApiResult = new EliApiResult();
        EliApiResult.setCode(eliApiCode);
        return EliApiResult;
    }

    public static EliApiResult success() {
        return new EliApiResult();
    }

    public static EliApiResult success(String msg) {
        return success(msg, null);
    }

    public static EliApiResult success(Object data) {
        EliApiResult EliApiResult = new EliApiResult();
        EliApiResult.setCode(EliApiCode.SUCCESS);
        EliApiResult.setData(data);
        return EliApiResult;
    }

    public static EliApiResult success(String msg, Object data) {
        EliApiResult EliApiResult = new EliApiResult();
        EliApiResult.setCode(EliApiCode.SUCCESS);
        EliApiResult.setMsg(msg);
        EliApiResult.setData(data);
        return EliApiResult;
    }
}
