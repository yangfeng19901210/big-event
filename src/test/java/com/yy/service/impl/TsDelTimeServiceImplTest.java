package com.yy.service.impl;

import com.yy.pojo.TsDelTime;
import com.yy.service.TsDelTimeService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TsDelTimeServiceImplTest {
    @Resource
    private TsDelTimeService tsDelTimeService;
    @Test
    void add(){
        TsDelTime tsDelTime = new TsDelTime();
        tsDelTime.setName("zs");
        tsDelTimeService.save(tsDelTime);
    }
    @Test
    void remove(){
        tsDelTimeService.removeById(2);
    }
    @Test
    void getById() {
        TsDelTime tsDelTime = tsDelTimeService.getById(2);
        assertNotNull(tsDelTime);
        System.out.println(tsDelTime);
    }

}