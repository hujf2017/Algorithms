package java面试.字符串;

import javax.annotation.PostConstruct;

/**
 * @Author hujf
 * @Date 2022/10/18 11:21
 * @Description TODO
 */
public class le1024 {
    static int[] num = {0, 28, 31, 16, 19, 0};
    static String[] fuhao = {"&", "//"};

    public boolean markov() {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int num1 = num[i] & num[j];
                for (int k = i + 2; k < num.length; k++) {
                    if (num[k] == 0) {
                        continue;
                    }
                    int num2 = num1 / num[k];
                    if (num2 == 1024) {
                        System.out.println(num[i] + " " + num[j] + " " + num[k]);
                    }
                }
            }
        }

        return false;

    }

    @PostConstruct
    public void t() {
        System.out.println("before");
    }

    public le1024() {
    }

    public static void main(String[] args) {
        le1024 le1024 = new le1024();
        le1024.markov();
    }
}
