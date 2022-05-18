package com.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Member;
import com.forum.mapper.IMemberMapper;
import com.forum.service.IMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

@Service
@RequiredArgsConstructor
public class MemberServicePlus extends ServiceImpl<IMemberMapper, Member> implements IMemberService {
    private final JedisPool pool;

}
