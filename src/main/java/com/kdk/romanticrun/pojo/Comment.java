package com.kdk.romanticrun.pojo;

import lombok.Data;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: fengzetao
 * @Date: 2021/12/12 7:51 下午
 */
@Data
public class Comment implements Comparable<Comment> {

    private String cid;
    private String uid;
    private String fuid;
    private String content;
    private String commentTime;

    @SneakyThrows
    @Override
    public int compareTo(Comment o) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date1 = this.getCommentTime();
        String date2 = o.getCommentTime();
        return (int) (df.parse(date2).getTime() - df.parse(date1).getTime()) / 1000;
    }
}
