package com.exam.test.service;

import com.exam.test.vo.User;

/**
*@author: cl
*@version : 2018年12月3日 下午4:45:01
*
*
*/

public interface UserService {
	User findAllUser();
	User findUserById(String userid);
	User findByName(String username,String password);
	String getPassword(String username);
}
