package com.kdk.romanticrun.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: fengzetao
 * @Date: 2021/12/12 7:51 下午
 */
@Data
public class Comment implements Comparable<Comment>{

    private String cid;
    private String uid;
    private String fuid;
    private String content;
    private Date commentTime;

    @Override
    public int compareTo(Comment o) {
        Date date1 = this.getCommentTime();
        Date date2 = o.getCommentTime();
        return (int) ((date1.getTime() - date2.getTime()) / 1000);
    }
}
