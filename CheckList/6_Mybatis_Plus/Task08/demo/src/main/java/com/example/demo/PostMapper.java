package com.example.demo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface PostMapper extends BaseMapper<Posts> {

    Posts selectAdvanced(@Param("id") long id);
}
