package com.exam.test.service.Impl;

import com.exam.test.mapper.InformationMapper;
import com.exam.test.service.InformationService;
import com.exam.test.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Override
    public Account selectAcount(String projectId) {
        return informationMapper.selectAcount(projectId);
    }
}
