package com.kdk.romanticrun.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class FreeRun implements Comparable<FreeRun> {

    /**
     * uid：         用户uid
     * totalMile：   总里程数
     * runTime:      跑步时间
     * runDate:      跑步日期
     */

    private String uid;
    private float totalMile;
    private String runTime;
    private Date runDate;


    @Override
    public int compareTo(FreeRun freeRun) {
        Date date1 = this.getRunDate();
        Date date2 = freeRun.getRunDate();
        return (int) ((date1.getTime() - date2.getTime()) / 1000);
    }

}