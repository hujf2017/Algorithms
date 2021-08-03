package pat.数字类;

import java.io.*;

/**
 * @author Hujf
 * @title: pat1
 * @date 2021-07-15 9:20
 * @description: 两数之和
 */
public class pat1 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String  []line = reader.readLine().split(" ");
        int num1 = Integer.parseInt(line[0]);
        int num2= Integer.parseInt(line[1]);
        System.out.printf("%,d\n",num1+num2);
    }
}
