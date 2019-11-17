package com.age.demo.controller.query;

import com.age.demo.bean.ResponseBean;
import com.age.demo.service.query.QueryDataDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryDataDetailEndpoint {

    @Autowired
    QueryDataDetailService queryDataDetailService;

    @GetMapping(value = "/age/query/QueryDataDetail")
    public ResponseBean queryDataDetail(){
        return queryDataDetailService.run();
    }
}
