package com.yy.common;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.yy.config.BaseConstant;
import io.gitee.loulan_yxq.owner.core.tool.ObjectTool;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName BaseStorage
 * @Description TODO
 * @Author yangFeng
 * @Date 2025/6/8 21:36
 * @Version 1.0
 */
public class BaseStorage {
    private static ThreadLocal<Map<String, String>> threadLocal = new TransmittableThreadLocal<>();
    public static void pushTaskId(String taskId) {
        push(BaseConstant.TASK_ID, taskId);
    }

    public static String getTaskId() {
        return get(BaseConstant.TASK_ID);
    }
    public static void push(String key, String value) {
        Map<String, String> map = threadLocal.get();
        if (map == null) {
            map = new LinkedHashMap<>();
            threadLocal.set(map);
        }
        map.put(key, value);
    }
    public static String get(String key) {
        Map<String, String> map = threadLocal.get();
        if (map == null) {
            map = new LinkedHashMap<>();
            threadLocal.set(map);
        }
        return map.get(key);
    }
    public static void pushUserId(Integer userId) {
        push(BaseConstant.USER_ID, ObjectTool.isNotNull(userId) ? String.valueOf(userId) : null);
    }

    public static Integer getUserId() {
        String userId = get(BaseConstant.USER_ID);
        if (ObjectTool.isNull(userId)) {
            return null;
        } else {
            return Integer.valueOf(userId);
        }
    }
    public static void pushUsername(String username) {
        push(BaseConstant.USERNAME, username);
    }

    public static String getUsername() {
        return get(BaseConstant.USERNAME);
    }
    public static void remove() {
        threadLocal.remove();
    }
}
