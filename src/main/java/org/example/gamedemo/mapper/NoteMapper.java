package org.example.gamedemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.gamedemo.entity.Note;

@Mapper
public interface NoteMapper extends BaseMapper<Note> {
//基本上继承了以后很多方法都已经写进去了，只有没有的方法需要用传统的mybatis的方法写
//然后需要在mapper里写声明，然后在resource里写batis脚本
}
