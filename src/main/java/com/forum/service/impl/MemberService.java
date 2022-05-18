package com.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Member;
import com.forum.mapper.IMemberMapper;
import com.forum.service.IMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//- 服务层相关的bean
@Service
//生产带final属性的构造函数
@RequiredArgsConstructor
public class MemberService  extends ServiceImpl<IMemberMapper, Member> implements IMemberService {
}
