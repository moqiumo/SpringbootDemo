package com.exam.test.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Menu {
    private int id;
    private String authName;
    private String children;
    
}
