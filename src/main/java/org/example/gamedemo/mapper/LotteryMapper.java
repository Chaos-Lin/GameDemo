package org.example.gamedemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.gamedemo.entity.Lottery; 
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LotteryMapper extends BaseMapper<Lottery> {
    // ... existing code ...
}