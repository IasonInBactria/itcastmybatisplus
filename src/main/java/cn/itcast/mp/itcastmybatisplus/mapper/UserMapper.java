package cn.itcast.mp.itcastmybatisplus.mapper;

import cn.itcast.mp.itcastmybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {

}
