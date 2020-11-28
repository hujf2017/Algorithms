package 基础.时间类.新特性18;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: 比较时间
 * @date 2020/11/28 0028上午 11:38
 * @description: 当前连续签到最大数和最近天数
 */
public class 比较时间 {
    @Test
    public void t(){
        String s ="2020-11-28";
        String s2 ="2020-11-29";
        String s3 ="2020-11-30";
        String s4 ="2020-12-01";
        String s5 ="2020-12-02";
        String s6 ="2020-12-03";
        String s7 ="2020-12-04";
        String s8 ="2020-12-05";
        List <String>date = new ArrayList<>();
        date.add(s);
        date.add(s2);
        date.add(s3);
        date.add(s4);
        date.add(s5);
        date.add(s6);
        date.add(s7);
        date.add(s8);

        int countNow=0;
        int countMax=0;
        LocalDate datex = LocalDate.of(2020,11,27);
        for(String sx :date){
            LocalDate ds = LocalDate.parse(sx, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            while(!ds.isEqual(datex)){
                if(countMax<countNow){
                    countMax = countNow;
                }
                countNow=0;
                datex =datex.minusDays(-1);
            }
            countNow++;
            datex =datex.minusDays(-1);
        }
        System.out.println("当前连续天数："+countNow+" 最大连续天数："+Math.max(countMax,countNow));
    }
}
