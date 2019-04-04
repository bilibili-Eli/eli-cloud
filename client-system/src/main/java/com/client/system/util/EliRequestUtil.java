package com.client.system.util;

import org.springframework.data.redis.core.HashOperations;

import javax.servlet.http.HttpServletRequest;

public class EliRequestUtil {

    public static String getUserId(HttpServletRequest request, HashOperations<String, String, String> hashOperations) {
        return hashOperations.get("eli", request.getHeader("user-token"));
    }
}
