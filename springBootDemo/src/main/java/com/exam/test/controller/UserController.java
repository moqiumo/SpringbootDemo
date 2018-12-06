package com.exam.test.controller;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.test.service.UserService;
import com.exam.test.vo.User;



/**
*@author: cl
*@version : 2018年12月3日 下午4:40:29
*
*
*/
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userServiceImpl;
	
	@RequestMapping("/userList")
	public List<User> getAllUser(){
		return userServiceImpl.findAllUser();
	}
}
