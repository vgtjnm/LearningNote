package com.example.demo.service.impl;


import com.example.demo.common.BusinessException;
import com.example.demo.dto.PostCreateDTO;
import com.example.demo.entity.Post;
import com.example.demo.mapper.PostMapper;
import com.example.demo.service.PostService;
import com.example.demo.vo.PostVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;

    @Override
    public PostVO getById(Long id) {
        Post post = postMapper.selectById(id);
        if (post == null) {
            throw new BusinessException(404, "文章不存在");
        }
        // 手动转换 Entity → VO
        PostVO vo = new PostVO();
        vo.setId(post.getId());
        vo.setTitle(post.getTitle());
        vo.setAuthor(post.getAuthor());
        vo.setCreateTime(post.getCreateTime());
        return vo;
    }

    @Override
    public void create(PostCreateDTO dto) {
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setAuthor(dto.getAuthor());
        postMapper.insert(post);
    }
}
