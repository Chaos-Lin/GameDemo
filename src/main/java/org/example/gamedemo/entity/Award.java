package org.example.gamedemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("award")
public class Award implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 奖品 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 奖品名称
     */
    private String name;

    /**
     * 奖品描述
     */
    private String description;

    /**
     * 奖品数量
     */
    private Integer quantity;

    /**
     * 剩余数量
     */
    private Integer remaining;

    // 可以根据实际需求添加更多字段
}