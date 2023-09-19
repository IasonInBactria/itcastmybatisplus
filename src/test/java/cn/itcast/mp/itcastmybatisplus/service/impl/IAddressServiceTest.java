package cn.itcast.mp.itcastmybatisplus.service.impl;

import cn.itcast.mp.itcastmybatisplus.service.IAddressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class IAddressServiceTest {
    @Autowired
    private IAddressService iAddressService;

    @Test
    public void testDelete(){
        iAddressService.removeById(59);
    }
}