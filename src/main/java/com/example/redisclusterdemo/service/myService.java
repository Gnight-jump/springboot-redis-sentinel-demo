package com.example.redisclusterdemo.service;/*
 * @Author: Gnight
 * @Date: 2021/3/12 20:27
 * @Description:
    服务端接口
 */

import com.example.redisclusterdemo.entity.User;

public interface myService {

    //增加
    public void insert(User user) throws Exception;

    //删除对应账户
    public void delete(String name) throws Exception;

    //更新
    public void update(User user) throws Exception;

    //根据查询
    public User select(String name) throws Exception;

}
