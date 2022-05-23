package com.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Comment;
import com.forum.entity.User;
import com.forum.mapper.ICommentMapper;
import com.forum.mapper.IUserMapper;
import com.forum.service.ICommentService;
import com.forum.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//- 服务层相关的bean
@Service
@RequiredArgsConstructor
public class CommentServicePlus extends ServiceImpl<ICommentMapper, Comment> implements ICommentService {

    private final ICommentMapper commentMapper;


}
