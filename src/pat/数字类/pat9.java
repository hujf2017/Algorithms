package pat.数字类;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Hujf
 * @title: pat9
 * @date 2021-08-04 10:28
 * @description: 两个多项式相乘
 */
public class pat9 {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(inputStreamReader);
        String[] s1 = buf.readLine().split(" ");
        String[] s2 = buf.readLine().split(" ");
        double[] ds = new double[2001];
        int count = 0;
        for (int i = 1; i < s1.length; i = i + 2) {
            for (int j = 1; j < s2.length; j = j + 2) {
                //得到当前设计
                int index = Integer.parseInt(s1[i]) + Integer.parseInt(s2[j]);
                double x = Double.parseDouble(s1[i + 1]) * Double.parseDouble(s2[j + 1]);
                if (ds[index] == 0 && x != 0) {
                    count++;
                }
                ds[index] += x;
            }
        }
        if (count > 0) {
            System.out.print(count);
        }
        for (int i = 2000; i >= 0; i--) {
            if (ds[i] != 0) {
                System.out.printf(" %d %.1f", i, ds[i]);
            }
        }
    }
}
