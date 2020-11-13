package leecode;

import org.junit.Test;

import java.util.Locale;

/**
 * @author Hujf
 * @title: le1507
 * @date 2020/11/10 0010下午 5:04
 * @description: TODO
 */
public class le1507 {
    public String reformatDate(String date) {
        java.text.SimpleDateFormat sdf = new  java.text.SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
        String s =date.replaceAll(" ","-");
        s = s.replaceAll("th","");
        try {
            java.util.Date date2 = sdf.parse(s);
            java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd");
            return simpleDateFormat.format(date2);

        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void t(){
        reformatDate("20th Oct 2052");
    }
}
