package java面试.字符串;

import com.sun.org.apache.regexp.internal.RE;

import javax.annotation.PostConstruct;

/**
 * @Author hujf
 * @Date 2022/10/18 11:21
 * @Description TODO
 */
public class le1024 {
    static int[] num = {28,5,0, 25, 31, 16, 19, 0,2};
    static String[] fuhao = {"%", "//", "&"};

    public boolean markov() {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (j == i) {
                    continue;
                }
                for (int k = 0; k < num.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }

                    for (int z = 0; z < num.length; z++) {
                        if (z == i || z == j || z == k) {
                            continue;
                        }

                        if (calc(num[i], num[j], num[k], num[z], fuhao)) {
                            System.out.println(num[i] + " " + num[j] + " " + num[k]);
                        }
                    }

                }
            }
        }

        return false;

    }

    private boolean calc(int i0, int i1, int i2, int i3, String[] fuhao) {
        int num = i0;
        int ks;
        for (int i = 0; i < fuhao.length; i++) {
            num = get(num, fuhao[i], i1);
            if (num == Integer.MAX_VALUE) {
                continue;
            }
            for (int j = 0; j < fuhao.length; j++) {
                if (j == i) {
                    continue;
                }
                if ( (ks=get(num, fuhao[j], i2)) == Integer.MAX_VALUE) {
                    continue;
                }
                num = ks;
                for (int k = 0; k < fuhao.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if ( (ks=get(num, fuhao[j], i2)) == Integer.MAX_VALUE) {
                        continue;
                    }
                    num = ks;
                }
            }
        }
        return false;
    }

    private int get(int num, String s, int num2) {
        switch (s) {
            case "%":
                if (num2 == 0) {
                    return Integer.MAX_VALUE;
                }
                num %= num2;
                break;
            case "//":
                if (num2 == 0) {
                    return Integer.MAX_VALUE;
                }
                num /= num2;
                break;
            case "&":
                num &= num2;

        }
        return num;
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
