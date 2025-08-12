package com.yy.common;

import io.gitee.loulan_yxq.owner.core.collection.ArrayTool;
import io.gitee.loulan_yxq.owner.core.tool.AssertTool;
import io.gitee.loulan_yxq.owner.core.tool.ObjectTool;

import java.util.*;

/**
 * 枚举通用父类
 * @ClassName CommonEnum
 * @Author yangfeng
 * @Date 2025/8/12 10:33
 * @Version 1.0
 */
public interface CommonEnum {
    Integer getCode();

    String getName();

    /**
     * 根据code获取对应的枚举对象
     * @param code
     * @param tClass
     * @Return: T
     * @author: yangfeng
     * @date: 2025/8/12 10:34
     **/
    static <T extends CommonEnum> T getByCode(Integer code, Class<T> tClass) {
        if (ObjectTool.isNull(code)) {
            return null;
        }
        T[] enumConstants = tClass.getEnumConstants();
        if (ArrayTool.isEmpty(enumConstants)) {
            return null;
        }
        Optional<T> tOptional = ArrayTool.stream(enumConstants).filter(o -> code.equals(o.getCode())).findFirst();
        return tOptional.get();
    }

    /**
     * 获取指定枚举类里面定义的所有数据
     * @param clzz
     * @Return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     * @author: yangfeng
     * @date: 2025/8/12 10:35
     **/
    static <E extends CommonEnum> List<Map<String, Object>> values(Class<?> clzz) {
        AssertTool.isTrue(clzz.isEnum(), "类型不正确。");
        AssertTool.isTrue(CommonEnum.class.isAssignableFrom(clzz), "枚举类型继承接口错误。");
        List<Map<String, Object>> list = new ArrayList<>();
        E[] enums = (E[]) clzz.getEnumConstants();
        for (E e : enums) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("name", e.getName());
            map.put("code", e.getCode());
//            map.put("className", clzz.getName());
            list.add(map);
        }
        return list;
    }

    static <E extends CommonEnum> List<E> getAllValues(Class<?> clazz) {
        AssertTool.isTrue(clazz.isEnum(), "类型不正确。");
        AssertTool.isTrue(CommonEnum.class.isAssignableFrom(clazz), "枚举类型继承接口错误。");
        E[] enums = (E[]) clazz.getEnumConstants();
        return Arrays.asList(enums);
    }
}
