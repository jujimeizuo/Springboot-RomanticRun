package com.kdk.romanticrun.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
public class UploadController {

    @Value("${image.upload.path.acm}")
    String filePath;

    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();

        File dest = new File(filePath + fileName);
        try {
            System.out.println("ok");
            file.transferTo(dest);
            // LOGGER.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            // LOGGER.error(e.toString(), e);
        }
        return "上传失败！";
    }
}
