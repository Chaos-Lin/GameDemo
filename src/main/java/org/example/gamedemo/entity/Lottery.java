package org.example.gamedemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("lottery")
public class Lottery implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 抽奖 ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 抽奖名称
     */
    private String name;

    /**
     * 抽奖开始时间
     */
    private Date startTime;

    /**
     * 抽奖结束时间
     */
    private Date endTime;

    /**
     * 抽奖状态（0: 未开始, 1: 进行中, 2: 已结束）
     */
    private Integer status;

    /**
     * 奖品总数
     */
    private Integer totalPrizes;

    /**
     * 剩余奖品数
     */
    private Integer remainingPrizes;

    // 可以根据实际需求添加更多字段

}