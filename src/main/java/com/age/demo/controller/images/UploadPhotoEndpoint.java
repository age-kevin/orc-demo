package com.age.demo.controller.images;

import com.age.demo.bean.ResponseBean;
import com.age.demo.bean.words_result;
import com.age.demo.service.execute.ExecuteService;
import com.age.demo.service.execute.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/age/images/UploadPhoto")
public class UploadPhotoEndpoint {

    @Autowired
    ExecuteService executeService;

    @Autowired
    ExportService exportService;

    // 上传地址
    @Value("${file.upload.path}")
    private String filePath;

    @RequestMapping("/v1.0")
    public ResponseBean uploadPhoto(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException, URISyntaxException {
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        // 定义上传文件保存路径
        String path = filePath + "rotPhoto/";
        // 新建文件
        File filepath = new File(path, filename);

        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }

        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = path + filename;
        List<words_result> wordsResults = executeService.checkFile(url);

        if (wordsResults != null && wordsResults.size() > 0) {
            return ResponseBean.actionSuccess("", "");
        } else {
            return ResponseBean.actionFail("数据插入失败！");
        }

//        //设置默认的下载文件名
//        String name = "数据.xlsx";
//        try {
//            //避免文件名中文乱码，将UTF8打散重组成ISO-8859-1编码方式
//            name = new String (name.getBytes("UTF8"),"ISO-8859-1");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        //设置响应头的类型
//        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//        //让浏览器下载文件,name是上述默认文件下载名
//        response.addHeader("Content-Disposition","attachment;filename=\"" + name + "\"");
//        InputStream inputStream=null;
//        OutputStream outputStream=null;
//        //在service层中已经将数据存成了excel临时文件，并返回了临时文件的路径
//        String downloadPath = exportService.export(wordsResults);
//        //根据临时文件的路径创建File对象，FileInputStream读取时需要使用
//        File fileExport = new File(downloadPath);
//        try {
//            //通过FileInputStream读临时文件，ServletOutputStream将临时文件写给浏览器
//            inputStream = new FileInputStream(fileExport);
//            outputStream = response.getOutputStream();
//            int len = -1;
//            byte[] b = new byte[1024];
//            while((len = inputStream.read(b)) != -1){
//                outputStream.write(b);
//            }
//            //刷新
//            outputStream.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            //关闭输入输出流
//            try {
//                if(inputStream != null) {
//                    inputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(outputStream != null) {
//                    outputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//        //最后才能，删除临时文件，如果流在使用临时文件，file.delete()是删除不了的
//        fileExport.delete();
//        System.out.println("==============xls文件生成成功==============");
    }

}
