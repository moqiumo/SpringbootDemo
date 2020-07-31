package com.exam.test.mapper;

import com.exam.test.vo.User;
import org.apache.ibatis.annotations.Mapper;



/**
*@author: cl
*@version : 2018年12月3日 下午4:46:52
*
*
*/
@Mapper
public interface UserMapper {
	User findAllUser();
	User findUserById(Integer id);
	User findByName(String username, String password);
	String getPassword(String username);
}
