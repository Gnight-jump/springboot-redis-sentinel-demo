package com.example.redisclusterdemo.service.impl;/*
 * @Author: Gnight
 * @Date: 2021/3/12 20:24
 * @Description:
    服务提供增删查改，加入了redis缓存
 */

import com.example.redisclusterdemo.dao.UserMapper;
import com.example.redisclusterdemo.entity.User;
import com.example.redisclusterdemo.service.myService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements myService {

    @Autowired
    private UserMapper userMapper;
    //使用name存储user信息 -- name唯一
    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(String name) {
        userMapper.deleteByName(name);
        if (redisTemplate.opsForValue().get(name) != null) {
            redisTemplate.delete(name);
        }
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
        if (redisTemplate.opsForValue().get(user.getName()) != null) {
            redisTemplate.delete(user.getName());
        }
    }

    @Override
    public User select(String name) {
        User user = null;
        try {
            user = (User) redisTemplate.opsForValue().get(name);
        }catch (Exception e){
            System.out.println("redis不存在该数据");
        }
        if (user == null) {
            System.out.println("数据库搜索");
            user = userMapper.selectByName(name);
            if (user != null) {//存在的话
                redisTemplate.opsForValue().set(name, user);
            }
        }
        return user;
    }
}
