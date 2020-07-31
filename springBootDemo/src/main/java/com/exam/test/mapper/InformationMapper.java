package com.exam.test.mapper;

import com.exam.test.vo.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InformationMapper {
    Account selectAcount(String projectId);
}
