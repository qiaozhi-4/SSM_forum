package com.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Reply;
import com.forum.mapper.IReplyMapper;
import com.forum.service.IReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

@Service
@RequiredArgsConstructor
public class ReplyServicePlus extends ServiceImpl<IReplyMapper, Reply> implements IReplyService {
    private final JedisPool pool;

}
