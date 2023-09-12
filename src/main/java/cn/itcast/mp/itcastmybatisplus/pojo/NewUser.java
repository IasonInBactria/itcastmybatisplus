package cn.itcast.mp.itcastmybatisplus.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@TableName("user")
public class NewUser {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    @TableField(select = false)
    private String password;
    private String phone;
    private String info;
    private Integer status;
    private Integer balance;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
