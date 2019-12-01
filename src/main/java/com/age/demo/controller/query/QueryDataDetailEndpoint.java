package com.age.demo.controller.query;

import com.age.demo.bean.ResponseBean;
import com.age.demo.service.query.QueryDataDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/age/query/QueryDataDetail")
public class QueryDataDetailEndpoint {

    @Autowired
    QueryDataDetailService queryDataDetailService;

    @GetMapping("/v1.0")
    @CrossOrigin(origins = "*")
    public ResponseBean queryDataDetail(){
        return queryDataDetailService.run();
    }
}
