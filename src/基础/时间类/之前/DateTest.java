package 基础.时间类.之前;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Hujf
 * @title: DateTest
 * @date 2020/11/20 0020下午 3:18
 * @description: TODO
 */
public class DateTest  {

    /**
     * 转换时间戳和时间
     */
    @Test
    public void date1(){
        Date date  = new Date();
        System.out.println("毫秒："+date.getTime());
        System.out.println("毫秒："+System.currentTimeMillis());
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time  = sdf.format(date);
        System.out.println("时间转字符串"+time );
    }

    /**
     * 转换时间戳和时间
     */
    @Test
    public void date2() throws ParseException {
        Date date  = new Date();

        System.out.println("毫秒："+date.getTime());
        System.out.println("毫秒："+System.currentTimeMillis());

        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time  = sdf.format(date);
        System.out.println("时间转字符串"+time );

        String time02 = "2018-09-05";
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date  date2  = sdf2.parse(time02);
        System.out.println(date2.getTime());
    }
}
