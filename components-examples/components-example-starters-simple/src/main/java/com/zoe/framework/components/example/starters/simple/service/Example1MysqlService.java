package com.zoe.framework.components.example.starters.simple.service;

import com.zoe.framework.components.example.starters.simple.entity.msyql.Example1;
import com.zoe.framework.components.example.starters.simple.mapper.mysql.Example1Mapper;
import com.zoe.framework.components.starter.database.service.impl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 蒋时华
 * @date 2023-12-01 09:52:25
 */
@Service
public class Example1MysqlService extends SuperServiceImpl<Example1Mapper, Example1> {


}
