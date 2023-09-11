package cn.itcast.mp.itcastmybatisplus.mapper;

import cn.itcast.mp.itcastmybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Update("update tb_user set age = age - ${amount} ${ew.customSqlSegment}")
    void updateAgeByCustomWrapper(@Param("amount") int amount, @Param("ew")QueryWrapper<User> userQueryWrapper);
}
