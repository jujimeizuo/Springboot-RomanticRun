package com.kdk.romanticrun.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class RomanticRun {

    /**
     * uid：         用户uid
     * totalMile：   总里程数
     * runTime:      跑步时间
     * runDate:      跑步日期
     */

    private String uid;
    private float totalMile;
    private Date runTime;
    private Date runDate;
}
