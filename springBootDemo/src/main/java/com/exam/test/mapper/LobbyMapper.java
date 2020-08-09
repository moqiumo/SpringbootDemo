package com.exam.test.mapper;


import com.exam.test.vo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LobbyMapper {
    List<Menu> findAllMenu();
}
