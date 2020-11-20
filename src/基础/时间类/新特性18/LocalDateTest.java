package 基础.时间类.新特性18;

import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Hujf
 * @title: LocalDateTest
 * @date 2020/11/20 0020下午 5:08
 * @description: TODO
 */
public class LocalDateTest {

    @Test
    public void t(){
        LocalDate now = LocalDate.now();
        System.out.println("当前时间"+now);

        // 02:自定义当前时间
        LocalDate date = LocalDate.of(1994,11,20);
        System.out.println("自定义当前时间:" + date);

        //03.修改时间格式
        String dateWithSring = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(dateWithSring);
    }
}
