package com.kdk.romanticrun.service.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RunMsgVO implements Comparable<RunMsgVO> {

    private String username;
    private String avator;
    private float totalMile;


    @Override
    public int compareTo(RunMsgVO o) {
        float total1 = this.getTotalMile();
        float total2 = o.getTotalMile();
        return (int) (total1 - total2) * 100;
    }
}
