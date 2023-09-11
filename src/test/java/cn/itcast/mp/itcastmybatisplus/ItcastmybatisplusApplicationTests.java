package cn.itcast.mp.itcastmybatisplus;

import cn.itcast.mp.itcastmybatisplus.mapper.UserMapper;
import cn.itcast.mp.itcastmybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class ItcastmybatisplusApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectList(){
        List<User> userList = userMapper.selectList(null);
        for (User user: userList){
            System.out.println(user);
        }
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setEmail("ssss@tt.com");
        user.setUserName("tianbg");
        user.setName("田伯光");
        user.setAge(43);
        user.setPassword("abcdef");
        int result = userMapper.insert(user);
        System.out.println("数据库受影响的行数为"+ result + "行");
        System.out.println("返回的ID:" + user.getId());
    }

    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(1L);
        user.setAge(19);
        user.setPassword("1qazXSWRR");

        userMapper.updateById(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setAge(20);
        user.setPassword("2edc&UGFI");
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name", "zhangsan");
        int result = userMapper.update(user, userQueryWrapper);
        System.out.println("执行结果:" + result);
    }

    @Test
    public void testUpdate2(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("age", 21).set("password", "1eoitejj").eq("user_name", "zhangsan");
//        User user = new User();
//        user.setAge(20);
//        user.setPassword("2edc&UGFI");
//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.eq("user_name", "zhangsan");
        int result = userMapper.update(null, updateWrapper);
        System.out.println("执行结果:" + result);
    }

    @Test
    public void testDeleteByMap(){
        Map<String, Object> deleteMap = new HashMap<>();
        deleteMap.put("user_name", "zhangsan");
        deleteMap.put("password", "123456");
        userMapper.deleteByMap(deleteMap);
    }

    @Test
    public void testSelectOne(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("user_name", "lisi");
        User user_item = userMapper.selectOne(userQueryWrapper);
        System.out.println(user_item);
    }

    @Test
    public void testSelectList2(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("email", "itcast");
        List<User> userList = userMapper.selectList(userQueryWrapper);
        for (User user_item: userList){
            System.out.println(user_item);
        }
    }

    @Test
    public void testSelectPage(){
        Page<User> userPage = new Page<>(1, 1);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("email", "itcast");

        IPage<User> iPage = userMapper.selectPage(userPage, userQueryWrapper);
        System.out.println("数据总条数:" + iPage.getTotal());
        System.out.println("数据总页数:"+ iPage.getPages());
        System.out.println("当前页数:" + iPage.getCurrent());

        List<User> userList = iPage.getRecords();
        for (User user_item: userList){
            System.out.println(user_item);
        }
    }

    @Test
    public void testLambdaQueryWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().select(User::getId, User::getUserName, User::getEmail).like(User::getUserName, "t")
                .ge(User::getAge, 22);
        userMapper.selectList(wrapper);
    }

    @Test
    public void testCustomWrapper(){
        int amount = 2;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        List<Long> ids = new ArrayList<>(Arrays.asList(1L, 2L, 3L));
        userQueryWrapper.in("id", ids);
        userMapper.updateAgeByCustomWrapper(amount, userQueryWrapper);
    }
}
