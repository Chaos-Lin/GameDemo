package org.example.gamedemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.gamedemo.entity.Award; // 假设存在对应的实体类
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AwardMapper extends BaseMapper<Award> {
    // 这里可以添加数据库操作方法
}