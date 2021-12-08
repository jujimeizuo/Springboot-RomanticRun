package com.kdk.romanticrun.pojo;

import lombok.Data;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;

@Data
public class Dynamic implements Comparable<Dynamic> {

    private String username;
    private String issueTime;
    private String issue;
    private Integer commentNumber;
    private Integer likeNumber;

    @SneakyThrows
    @Override
    public int compareTo(Dynamic o) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

        String date1 = this.getIssueTime();
        String date2 = o.getIssueTime();
        return (int)(df.parse(date2).getTime() - df.parse(date1).getTime()) / 1000;
    }
}
