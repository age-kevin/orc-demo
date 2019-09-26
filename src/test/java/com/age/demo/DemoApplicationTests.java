package com.age.demo;

import com.age.demo.service.execute.ExecuteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    ExecuteService executeService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test01() throws IOException, URISyntaxException {
        executeService.checkFile("D:/TestWorkspace/orc-demo/20190926091857.png");
    }

}
