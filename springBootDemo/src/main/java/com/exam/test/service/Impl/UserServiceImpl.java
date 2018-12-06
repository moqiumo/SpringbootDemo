package com.exam.test.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.test.mapper.UserMapper;
import com.exam.test.service.UserService;
import com.exam.test.vo.User;



/**
*@author: cl
*@version : 2018年12月3日 下午4:45:30
*
*
*/
@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<User> findAllUser() {
		return userMapper.findAllUser();
	}

}
