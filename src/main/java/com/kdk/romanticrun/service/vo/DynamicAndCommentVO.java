package com.kdk.romanticrun.service.vo;

import com.kdk.romanticrun.pojo.CommentWithDynamic;
import lombok.Data;
import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

@Data
public class DynamicAndCommentVO implements Comparable<DynamicAndCommentVO> {

    /**
     * 广场动态
     */
    private String did;
    private String uid;
    private String username;
    private String avator;
    private String issueTime;
    private String issue;
    private Integer commentNumber;
    private Integer likeNumber;
    private List<String> pics;

    /**
     * 动态下的评论
     */
    List<CommentWithDynamic> commentWithDynamics;


    @SneakyThrows
    @Override
    public int compareTo(DynamicAndCommentVO o) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date1 = this.getIssueTime();
        String date2 = o.getIssueTime();
        return (int) (df.parse(date2).getTime() - df.parse(date1).getTime()) / 1000;
    }
}
