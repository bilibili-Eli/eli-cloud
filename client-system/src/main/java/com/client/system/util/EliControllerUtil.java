package com.client.system.util;

import com.client.system.enums.EliApiCode;
import com.client.system.exception.EliException;
import com.client.system.model.EliApiResult;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class EliControllerUtil<Impl, Model> {
    /**
     * 查询全部
     */
    public static String SELECT_ALL = "selectAll";
    /**
     * 删除
     */
    public static String DELETE = "delete";
    /**
     * 更新
     */
    public static String UPDATE = "update";
    /**
     * 查询单个详情
     */
    public static String SELECT_BY_ID = "selectById";
    /**
     * 插入信息
     */
    public static String INSERT = "insert";
    /**
     * 条件查询
     */
    public static String SELECT = "select";

    /**
     * controller通用方法
     *
     * @param methodName 需要调用的方法名
     * @param impl       service实现类
     * @param resource   需要的数据
     * @param request    request域
     * @return 公用返回类
     */
    public EliApiResult invoke(String methodName, Impl impl, Model resource, HttpServletRequest request) {
        try {
            if (resource == null) {
                return EliApiResult.fail("参数对象无效！");
            }
            Object data = impl.getClass().getMethod(methodName, resource.getClass(), HttpServletRequest.class).invoke(impl, resource, request);
            if (data != null) return EliApiResult.success(data);
            else return EliApiResult.success();
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (cause instanceof EliException) {
                return EliApiResult.fail(cause.getMessage());
            } else {
                return EliApiResult.fail(EliApiCode.SYSTEM_INNER_ERROR);
            }
        }
    }
}
