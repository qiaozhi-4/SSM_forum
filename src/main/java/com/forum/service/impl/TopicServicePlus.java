package com.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Topic;
import com.forum.mapper.ITopicMapper;
import com.forum.service.ITopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

@Service
@RequiredArgsConstructor
public class TopicServicePlus extends ServiceImpl<ITopicMapper, Topic> implements ITopicService {
    private final JedisPool pool;
}
