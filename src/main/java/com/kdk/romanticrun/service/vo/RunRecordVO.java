package com.kdk.romanticrun.service.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RunRecordVO implements Comparable<RunRecordVO> {

    /**
     * type :        类型
     * totalMile：   总里程数
     * runTime:      跑步时间
     * runDate:      跑步日期
     */

    private int type;
    private float totalMile;
    private String runTime;
    private Date runDate;


    @Override
    public int compareTo(RunRecordVO runRecordVO) {
        Date date1 = this.getRunDate();
        Date date2 = runRecordVO.getRunDate();
        return (int) ((date2.getTime() - date1.getTime()) / 1000);
    }
}
