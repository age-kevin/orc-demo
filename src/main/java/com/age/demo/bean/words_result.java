package com.age.demo.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class words_result {
    private int idData;
    private String words;
    private String userName;
    private String userNumber;
    private String profit;
}
