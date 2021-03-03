package com.xtt.shardingjdbcdemo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description DICT
 * @Author Monster
 * @Date 2021/3/2 17:32
 * @Version 1.0
 */
@Data
@TableName(value = "t_udict")
public class Dict {
    private Long dictid;
    private String ustatus;
    private String uvalue;
}
