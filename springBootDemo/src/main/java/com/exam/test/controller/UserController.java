package com.exam.test.controller;

import com.exam.test.common.AjaxFilter;
import com.exam.test.common.JwtUtil;
import com.exam.test.service.UserService;
import com.exam.test.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	private static Logger logger = LoggerFactory.getLogger(AjaxFilter.class);
	
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

//	@PostMapping("/login")
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public Object login(@RequestBody User users){
//		JSONObject jsonObject=new JSONObject();
//		System.out.println("username:"+users.getUserName());
//		System.out.println("password:"+users.getPassword());
		logger.info(String.valueOf(users));
		User user = userService.findByName(users.getUserName(), users.getPassword());
		System.out.println(user);
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
