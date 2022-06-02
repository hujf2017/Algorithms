package 基础.数据类型;

import com.sun.javafx.binding.StringFormatter;
import javafx.beans.binding.StringExpression;

/**
 * @Author hujf
 * @Date 2022/5/17 11:15
 * @Description TODO
 */
public class Strings {
    public static void main(String[] args) {
        String sql = "select *from %s.%s";
        String format = String.format(sql, "a", "b");
        System.out.println(format);
    }
}
