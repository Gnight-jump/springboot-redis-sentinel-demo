package com.example.redisclusterdemo.controller;/*
 * @Author: Gnight
 * @Date: 2021/3/12 20:22
 * @Description:
    简单接口，增删查改
 */

import com.example.redisclusterdemo.entity.User;
import com.example.redisclusterdemo.service.impl.MyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class myTest {

    @Autowired
    private MyServiceImpl myService;

    @GetMapping("/insert")
    public Map insertUser(User user) {
        try {
            myService.insert(user);
        } catch (Exception e) {
            return result(-1, "错误");
        }
        return result(0, "成功");
    }

    @GetMapping("/delete")
    public Map deleteUser(String name) {
        try {
            myService.delete(name);
        } catch (Exception e) {
            return result(-1, "错误");
        }
        return result(0, "成功");
    }

    @GetMapping("/select")
    public Map selectUser(String name) {
        User select = null;
        try {
            select = myService.select(name);
        } catch (Exception e) {
            return result(-1, "错误");
        }
        return result(0, select);
    }

    @GetMapping("/update")
    public Map updateUser(User user) {
        try {
            myService.update(user);
        } catch (Exception e) {
            return result(-1, "错误");
        }
        return result(0, "成功");
    }


    //封装返回结果
    public Map result(int code, Object data) {
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", code);
        res.put("data", data);
        return res;
    }


}
