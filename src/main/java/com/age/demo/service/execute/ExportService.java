package com.age.demo.service.execute;

import com.age.demo.bean.words_result;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExportService {
    //创建临时文件存放的路径
    private String temp="D:\\temp\\excel\\";

    public String export(List<words_result> wordsResults){
        //创建工作簿
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = xssfWorkbook.createSheet();
        xssfWorkbook.setSheetName(0,"数据表");
        //创建表头
        XSSFRow head = sheet.createRow(0);
        String[] heads = {"用户名","编号","收益"};
        for(int i = 0;i < 3;i++){
            XSSFCell cell = head.createCell(i);
            cell.setCellValue(heads[i]);
        }
        int size = wordsResults.size() / 3;
        for (int i = 1;i <= size;i++) {
            words_result wordsResult = wordsResults.get(i - 1);
            //创建行,从第二行开始，所以for循环的i从1开始取
            XSSFRow row = sheet.createRow(i);
            //创建单元格，并填充数据
            XSSFCell cell = row.createCell(0);
            cell.setCellValue(wordsResult.getUserName());
            cell = row.createCell(1);
            cell.setCellValue(wordsResult.getNumber());
            cell = row.createCell(2);
            cell.setCellValue(wordsResult.getProfit());
        }
        //创建临时文件的目录
        File file = new File(temp);
        if(!file.exists()){
            file.mkdirs();
        }
        //临时文件路径/文件名
        String downloadPath = file + "\\"  +System.currentTimeMillis();
        OutputStream outputStream = null;
        try {
            //使用FileOutputStream将内存中的数据写到本地，生成临时文件
            outputStream = new FileOutputStream(downloadPath);
            xssfWorkbook.write(outputStream);
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return downloadPath;
    }
}
