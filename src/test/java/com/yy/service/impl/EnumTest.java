package com.yy.service.impl;

import com.yy.common.CommonEnum;
import com.yy.enums.Season;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * 枚举测试类
 * @ClassName EnumTest
 * @Author yangfeng
 * @Date 2025/8/12 10:52
 * @Version 1.0
 */
public class EnumTest {
    @Test
    void getByCode(){
        Season season = CommonEnum.getByCode(1, Season.class);
        System.out.println(season.getName());
    }
    @Test
    void getEnumsValues(){
        List<Map<String, Object>> values = CommonEnum.values(Season.class);
        System.out.println(values);
    }
}