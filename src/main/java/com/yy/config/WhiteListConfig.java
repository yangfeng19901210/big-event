package com.yy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/*********************************************************
 **
 ** <br><br>
 ** @ClassName: WhiteListConfig
 ** @author: yangfeng
 ** @date: 2025/7/23 14:39
 ** @version: 1.0.0
 *********************************************************/
@Component
@ConfigurationProperties(prefix = "security") // 前缀与配置一致
@Data
public class WhiteListConfig {
    private List<String> whiteList;
}
