package cn.itcast.mp.itcastmybatisplus.service.impl;

import cn.itcast.mp.itcastmybatisplus.enums.UserStatus;
import cn.itcast.mp.itcastmybatisplus.pojo.NewUser;
import cn.itcast.mp.itcastmybatisplus.pojo.User;
import cn.itcast.mp.itcastmybatisplus.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        user.setStatus(UserStatus.NORMAL);
        iUserService.save(user);
    }

    @Test
    public void testSelectUser(){
        List<User> userList = iUserService.list(new QueryWrapper<User>().like("user_name", "z"));
        userList.forEach(System.out::println);
    }

    @Test
    public void TestLambdaQuery(){
        User curUser = iUserService.lambdaQuery().eq(User::getUserName, "lisi").one();
        System.out.println("user =" + curUser);
        List<User> list = iUserService.lambdaQuery().like(User::getUserName, "o").list();
        list.forEach(System.out::println);
        Long count = iUserService.lambdaQuery().like(User::getUserName, "o").count();
        System.out.println("count = " + count);
    }


    public List<User> queryUser(String userName, Integer status, Long minAge, Long maxAge){
        return iUserService.lambdaQuery().like(User::getUserName, userName).eq(User::getStatus, status)
                .gt(minAge != null, User::getAge, minAge)
                .lt(maxAge != null, User::getAge, maxAge)
                .list();
    }

    @Test
    public void testQueryUsers(){
        List<User> list = queryUser("i", 1, null, null);
        list.forEach(System.out::println);
    }

    @Test
    public void testLambdaUpdate(){
        updateAge(11L, 1L, null);
    }


    public void updateAge(Long age, Long id, String userName){
        if (id == null && userName != null){
            throw new RuntimeException("更新条件不能为空！");
        }
        iUserService.lambdaUpdate().set(User::getAge, age)
                .eq(userName != null, User::getUserName, userName)
                .set(User::getStatus, 1)
                .eq(id != null, User::getId, id)
                .update();

    }

    public void testPageQuery(){
        int pageNo = 1, pageSize = 2;
        //准备分页插件
        Page.of(pageNo, pageSize);
    }
}