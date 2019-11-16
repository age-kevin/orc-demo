package com.age.demo.service.execute;

import com.age.demo.bean.SourceData;
import com.age.demo.bean.words_result;
import com.age.demo.service.auth.AuthService;
import com.age.demo.service.auth.BaseImg64;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class ExecuteService {

    @Autowired
    AuthService authService;

    @Autowired
    ExportService exportService;

    String POST_URL = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic?access_token=" + authService.getAuth();

    /**
     * 识别本地图片的文字
     */
    public List<words_result> checkFile(String path) throws URISyntaxException, IOException {
        File file = new File(path);
        if (!file.exists()) {
            throw new NullPointerException("图片不存在");
        }
        String image = BaseImg64.getImageStrFromPath(path);
        String param = "image=" + image;
        return post(param);
    }

    /**
     * 图片url
     * 识别结果，为json格式
     */
    public List<words_result> checkUrl(String url) throws IOException, URISyntaxException {
        String param = "url=" + url;
        return post(param);
    }

    /**
     * 通过传递参数：url和image进行文字识别
     */
    private List<words_result> post(String param) {
        //开始搭建post请求
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpMethod method = HttpMethod.POST;
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity httpEntity = new HttpEntity(param,headers);
        ResponseEntity<String> strbody = restTemplate.exchange(POST_URL,method,httpEntity,String.class);
        JSONObject json = JSONObject.parseObject(strbody.getBody());
        SourceData sourceData = json.toJavaObject(SourceData.class);
        List<words_result> wordsResults = sourceData.getWords_result();
        int size = wordsResults.size();
        int count = 0;
        for (int i = 0; i < size; i += 3){
            wordsResults.get(count).setUserName(wordsResults.get(i).getWords());
            wordsResults.get(count).setNumber(wordsResults.get(i + 1).getWords());
            wordsResults.get(count).setProfit(wordsResults.get(i + 2).getWords());
            System.out.println(wordsResults.get(count).getUserName() + " " + wordsResults.get(count).getNumber() + " " + wordsResults.get(count).getProfit());
            System.out.println();
            count++;
        }

        return wordsResults;
    }
}
