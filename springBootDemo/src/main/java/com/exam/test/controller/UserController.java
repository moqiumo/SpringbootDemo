package com.exam.test.controller;

import com.exam.test.common.JwtUtil;
import com.exam.test.service.UserService;
import com.exam.test.vo.User;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
*@author: cl
*@version : 2018年12月3日 下午4:40:29
*
*
*/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
    static Map<Integer, User> userMap=new HashMap<>();
	
	@RequestMapping("/a/userList")
	public User getAllUser(){ return userService.findAllUser();
	}

	@RequestMapping("/a/select")
	public User findUserById(@RequestParam String userid) {
		return userService.findUserById(userid);
	}

	@PostMapping("/login")
	public Object login(@RequestParam String username,@RequestParam String password){
		JSONObject jsonObject=new JSONObject();
		User user = userService.findByName(username, password);
		if(user==null){
			jsonObject.put("code", "400");
			jsonObject.put("message","登录失败,用户不存在");
			return jsonObject;
		}else{
			System.out.println(user);
            String token= JwtUtil.createToken(user);
            jsonObject.put("code", "200");
            jsonObject.put("message", "success");
            jsonObject.put("token", token);
            return jsonObject;
        }
	}

}
