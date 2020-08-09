package com.exam.test.service.Impl;

import com.exam.test.mapper.LobbyMapper;
import com.exam.test.service.LobbyService;
import com.exam.test.vo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LobbyServiceImpl implements LobbyService {
    @Autowired
    private LobbyMapper lobbyMapper;
    @Override
    public List<Menu> findAllMenu() {
        return lobbyMapper.findAllMenu();
    }
}
