package com.age.demo;

import com.age.demo.orc.OCR;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void Test01(){
        String path = "";
        try {
            String valCode = new OCR().recognizeText(new File(path), "png");
            System.out.println(valCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
