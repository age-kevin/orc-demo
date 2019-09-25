package com.age.demo;

import com.age.demo.service.auth.AuthService;
import com.age.demo.service.execute.ExecuteTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    ExecuteTest executeTest;

    @Test
    public void contextLoads() {
    }

    @Test
    public void Test01() throws IOException, URISyntaxException {
        executeTest.checkFile("C:/Users/Administrator/Desktop/picture/20190925220630.png");
    }

}
