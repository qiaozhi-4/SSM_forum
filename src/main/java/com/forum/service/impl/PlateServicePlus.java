package com.forum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.forum.entity.Plate;
import com.forum.mapper.IPlateMapper;
import com.forum.service.IPlateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

@Service
@RequiredArgsConstructor
public class PlateServicePlus extends ServiceImpl<IPlateMapper, Plate> implements IPlateService {
    private final JedisPool pool;

}
