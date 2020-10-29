package leecode;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Hujf
 * @title: le1154
 * @date 2020/10/29 0029下午 12:39
 * @description: TODO
 */
public class le1154 {
    public int dayOfYear(String date) {
//        Calendar c = new Calendar()
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate l = LocalDate.parse(date,df);
            return l.getDayOfYear();
    }
}
