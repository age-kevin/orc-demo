package com.age.demo.parameter;

import lombok.Data;

@Data
public class RegisterParameter {
    private String userName;
    private String password;
    private String privileges;
    private int group;
}
