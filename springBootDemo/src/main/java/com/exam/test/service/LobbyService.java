package com.exam.test.service;

import com.exam.test.vo.Account;
import com.exam.test.vo.Menu;

import java.util.List;


public interface LobbyService {

    List<Menu> findAllMenu();
    List<Account> findAccount(String projectType);
//    Object hpjyLottery();
}
