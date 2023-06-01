package com.lq.SmartWardrobe.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Pattern;

/**
 * <p>
 * 
 * </p>
 *
 * @author lq
 * @since 2023-06-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_donation")
public class Donation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    @Pattern(regexp = "^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@\"\n" +
            "                + \"[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")
    private String email;

    private String context;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
