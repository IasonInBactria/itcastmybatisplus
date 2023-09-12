package cn.itcast.mp.itcastmybatisplus.service.impl;

import cn.itcast.mp.itcastmybatisplus.mapper.UserMapper;
import cn.itcast.mp.itcastmybatisplus.pojo.NewUser;
import cn.itcast.mp.itcastmybatisplus.pojo.User;
import cn.itcast.mp.itcastmybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
