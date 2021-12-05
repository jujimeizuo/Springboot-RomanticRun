package com.kdk.romanticrun.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class FreeRun {

    /**
     * uid：         用户uid
     * totalMile：   总里程数
     * runStartTime：跑步开始时间
     * runEndTime：  跑步结束时间
     * runTime:      跑步日期
     * AverageSpeed：平均跑步时间
     */

    private String uid;
    private float totalMile;
    private Date runStartTime;
    private Date runEndTime;
    private Date runTime;
    private float AverageSpeed;

}