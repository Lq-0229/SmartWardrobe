package com.lq.SmartWardrobe.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author lq
 * @since 2023-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String repassword;

    private String email;


}
