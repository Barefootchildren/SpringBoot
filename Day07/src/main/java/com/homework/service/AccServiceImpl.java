package com.homework.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.homework.entity.Acc;
import com.homework.mapper.AccMapper;
import org.springframework.stereotype.Service;

@Service
@DS("slave")
public class AccServiceImpl extends ServiceImpl<AccMapper, Acc> implements AccService{
}
