package com.yy.enums;

import com.yy.common.CommonEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 一年四季枚举类
 * @ClassName Season
 * @Author yangfeng
 * @Date 2025/8/12 10:47
 * @Version 1.0
 */
@AllArgsConstructor
@Getter
public enum Season implements CommonEnum {
    SPRING(1, "春天"),
    SUMMER(2, "夏天"),
    AUTUMN(3, "秋天"),
    WINTER(4, "冬天");

    private Integer code;
    private String name;
}
