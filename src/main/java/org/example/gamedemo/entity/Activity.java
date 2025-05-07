package org.example.gamedemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("activity")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 活动描述
     */
    private String description;

    /**
     * 活动开始时间
     */
    private Date startTime;

    /**
     * 活动结束时间
     */
    private Date endTime;

    /**
     * 活动状态（0: 未开始, 1: 进行中, 2: 已结束）
     */
    private Integer status;

    // 可以根据实际需求添加更多字段
}