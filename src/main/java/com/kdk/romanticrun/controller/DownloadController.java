package com.kdk.romanticrun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
public class DownloadController {

    @Value("${image.download.path.acm}")
    private String filepath;

    @GetMapping("/download/{file}")
    public ResponseEntity<FileSystemResource> download(@PathVariable String file) {
//        if(file == null) {
//            log.info("文件为空");
//        }
        String path = filepath + file;

        log.info("{}下载中", file);
        FileSystemResource fileSystemResource = new FileSystemResource(path);
        if(!fileSystemResource.exists()){
            log.info("文件不存在");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().headers(getResponseHeaders(file)).body(fileSystemResource);
    }

    public HttpHeaders getResponseHeaders(String filename) {
        HttpHeaders headers = new HttpHeaders();
        ContentDisposition.Builder builder = ContentDisposition.builder("inline");
        // inline表示播放，attachment为下载到本地
        if (StringUtils.hasText(filename)) {
            builder.filename(filename, StandardCharsets.UTF_8);
        }
        headers.setContentDisposition(builder.build());
        headers.setContentType(new MediaType("video", "mp4"));
        return headers;
    }
}