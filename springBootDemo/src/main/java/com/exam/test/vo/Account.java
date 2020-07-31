package com.exam.test.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Account {
    public String projectId;
    public String accountNumber;
    public String password;
    public String openid;
}
