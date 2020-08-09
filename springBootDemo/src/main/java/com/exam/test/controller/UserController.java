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
	RestControllerHelper helper = new RestControllerHelper();
	
	@RequestMapping("/a/userList")
	public User getAllUser(){ return userService.findAllUser();
	}

	@RequestMapping("/a/select")
	public Map<String,Object> findUserById(@RequestParam Integer userid) {
		helper.setCode(RestControllerHelper.SUCCESS);
		helper.setMsg("success");
		helper.setData(userService.findUserById(userid)) ;
		return helper.toJsonMap();
	}

	@PostMapping("/login")
	public Object login(@RequestParam String username,@RequestParam String password){
		JSONObject jsonObject=new JSONObject();
		User user = userService.findByName(username, password);
		if(user==null){
			helper.setCode(RestControllerHelper.Parameter_Error);
			helper.setMsg("登录失败,账号或密码错误！");
			return helper.toJsonMapError();
		}else{
            String token= JwtUtil.createToken(user);
            helper.setCode(RestControllerHelper.SUCCESS);
            helper.setMsg("登录成功");
            helper.setData(token);
            return helper.toJsonMap();
        }
	}

}
