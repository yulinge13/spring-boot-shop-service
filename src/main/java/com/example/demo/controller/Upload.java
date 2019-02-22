package com.example.demo.controller;

import com.example.demo.entity.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@RestController
@CrossOrigin
public class Upload {

    @Autowired
    ResultMessage resultMessage ;

    private String UPLOAD_FOLDER = "src/main/resources/public/images/";

    private String XLSX_FILE = "src/main/resources/public/file/";

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public Object  uploadFile(HttpServletRequest res) {
        String pathname =  res.getSession().getServletContext().getRealPath("/public/images");
        System.out.println(pathname);
        List<MultipartFile> files =((MultipartHttpServletRequest)res).getFiles("file");
        List<Map> fileLists = new ArrayList<>();
        MultipartFile file = null;
        for (int i =0; i< files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                        byte[] bytes = file.getBytes();
                    Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
                    Map<String,String> fileInfo = new HashMap<>();
                    fileInfo.put("url",UPLOAD_FOLDER+file.getOriginalFilename());
                    //如果没有files文件夹，则创建
                    if (!Files.isWritable(path)) {
                        Files.createDirectories(Paths.get(UPLOAD_FOLDER));
                    }
                    //文件写入指定路径
                    Files.write(path, bytes);   
                    fileLists.add(fileInfo);
                } catch (IOException e) {
                    e.printStackTrace();
                    return resultMessage.failData(null,"后端异常...");
                }
            } else {
                return resultMessage.failData(null,"失败...");
            }
        }
        return resultMessage.successData(fileLists,"成功.");
    }
}
