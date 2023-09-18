package cn.itcast.mp.itcastmybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author YangY
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@TableName("tb_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    @TableField(select = false)
    private String password;
    private String name;
    private Integer age;
    private String email;
    private Integer status;
}
