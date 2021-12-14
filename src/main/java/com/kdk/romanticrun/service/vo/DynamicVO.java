package com.kdk.romanticrun.service.vo;

import lombok.Data;

import java.util.List;

@Data
public class DynamicVO {
    private String uid;
    private List<String> pic;
    private String issue;
}