package com.xtt.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description User
 * @Author Monster
 * @Date 2021/3/2 16:28
 * @Version 1.0
 */
@Data
@TableName(value = "t_user") //指定对应的表
public class User {
    private Long userId;
    private String username;
    private Boolean ustatus;
}
