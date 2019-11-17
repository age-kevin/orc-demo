package com.age.demo.mapper;

import com.age.demo.bean.words_result;

import java.util.List;

public interface DataMapper {
    void insertData(List<words_result> wordsResults);
    List<words_result> queryDataDetail();
}
