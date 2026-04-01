package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.dto.PostCreateDTO;
import com.example.demo.service.PostService;
import com.example.demo.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/{id}")
    public Result<PostVO> getById(@PathVariable Long id) {
        return Result.success(postService.getById(id));
    }

    @PostMapping
    public Result<Void> create(@RequestBody PostCreateDTO dto) {
        postService.create(dto);
        return Result.success(null);
    }
}

