package com.exam.test.service.Impl;

import com.exam.test.mapper.UserMapper;
import com.exam.test.service.UserService;
import com.exam.test.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
*@author: cl
*@version : 2018年12月3日 下午4:45:30
*
*
*/
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findAllUser() {
		return userMapper.findAllUser();
	}

    @Override
    public User findUserById(String userid) {

		return userMapper.findUserById(userid);
	}

	@Override
	public User findByName(String username, String password) {
		return userMapper.findByName(username, password);
	}

	@Override
	public String getPassword(String username) {
		return userMapper.getPassword(username);
	}
}
