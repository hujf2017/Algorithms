package 基础.时间类.之前;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Hujf
 * @title: CalendarTest
 * @date 2020/11/20 0020下午 4:01
 * @description: TODO
 */
public class CalendarTest {

    @Test
    public void t(){
        Calendar cal = Calendar.getInstance();
        System.out.println("年："+cal.get(Calendar.YEAR));
        System.out.println("月："+cal.get(Calendar.MONTH));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        cal.add(Calendar.DATE,+15);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str =sdf.format(cal.getTime());
        System.out.println("往后15日" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("往后15日" + str);
    }
}
