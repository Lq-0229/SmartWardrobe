package com.lq.SmartWardrobe.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

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
@TableName("tb_appraise")
public class Appraise implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer uId;

    private LocalDateTime createTime;

    @NotNull
    private String content;


}
