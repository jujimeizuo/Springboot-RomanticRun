package com.kdk.romanticrun.pojo;

import lombok.Data;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;

@Data
public class CommentWithDynamic implements Comparable<CommentWithDynamic>{

    private String username;
    private String content;
    private String commentTime;
    private String avator;

    @SneakyThrows
    @Override
    public int compareTo(CommentWithDynamic o) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date1 = this.getCommentTime();
        String date2 = o.getCommentTime();
        return (int) (df.parse(date2).getTime() - df.parse(date1).getTime()) / 1000;
    }
}
