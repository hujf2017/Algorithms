package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hujf
 * @title: le860
 * @date 2020/10/22 0022下午 5:46
 * @description: TODO
 */
public class le860 {
    public boolean lemonadeChange(int[] bills) {
        int a5 = 0;
        int a10 = 0;
        int a20 = 0;
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    a5++;
                    break;
                case 10:
                    if (a5 <= 0) {
                        return false;
                    }
                    a5--;
                    a10++;
                    break;
                default:
                    if (a10 > 0 && a5 > 0) {
                        a10--;
                        a5--;
                    } else if (a10 <= 0 && a5 >= 3) {
                        a5 = a5 - 3;
                    } else {
                        return false;
                    }
            }
        }
        return true;
    }
}
