package com.age.demo.bean;

import lombok.Data;

import java.util.List;

@Data
public class SourceData {
    private long log_id;
    private int words_result_num;
    private List<words_result> words_result;
}
