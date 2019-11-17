package com.age.demo.service.query;

import com.age.demo.bean.ResponseBean;
import com.age.demo.bean.words_result;
import com.age.demo.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryDataDetailService {

    @Autowired
    DataMapper dataMapper;

    public ResponseBean run(){
        List<words_result> list = dataMapper.queryDataDetail();
        return ResponseBean.actionSuccess(list, "");
    }
}
