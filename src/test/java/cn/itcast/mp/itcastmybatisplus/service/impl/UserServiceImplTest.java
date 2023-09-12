package cn.itcast.mp.itcastmybatisplus.service.impl;

import cn.itcast.mp.itcastmybatisplus.pojo.NewUser;
import cn.itcast.mp.itcastmybatisplus.pojo.User;
import cn.itcast.mp.itcastmybatisplus.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void testSaveUser(){
        User user = new User();
        user.setUserName("Elon Musk");
        user.setPassword("1234");
        user.setAge(50);
        user.setEmail("test@tesla.com");
        iUserService.save(user);
    }

    @Test
    public void testSelectUser(){
        List<User> userList = iUserService.list(new QueryWrapper<User>().like("user_name", "z"));
        userList.forEach(System.out::println);
    }
}