package com.example.demo.service;

import com.example.demo.dto.PostCreateDTO;
import com.example.demo.vo.PostVO;

public interface PostService {
    PostVO getById(Long id);
    void create(PostCreateDTO dto);
}
