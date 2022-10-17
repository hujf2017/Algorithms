package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/11 17:44
 * @Description TODO
 */
public class le2429 {
    public int minimizeXor(int num1, int num2) {
        int k = num1;
        int i = Integer.bitCount(k);
        int j = Integer.bitCount(num2);

        if (i > j) {
            //多1 从小到大去1
            String s = Integer.toBinaryString(k);
            char[] chars = s.toCharArray();
            int count = i - j;
            for (int x = chars.length - 1; x >= 0; x--) {
                if (chars[x] == '1') {
                    count--;
                    chars[x] = '0';
                    if (count == 0) {
                        break;
                    }
                }
            }

            return Integer.parseInt(new String(chars),2);

        } else if (i < j) {
            // 缺1 从小到达补1
            String s = Integer.toBinaryString(k);
            char[] chars = s.toCharArray();
            int count = j - i;
            for (int x = chars.length - 1; x >= 0; x--) {
                if (chars[x] == '0') {
                    count--;
                    chars[x] = '1';
                    if (count == 0) {
                        break;
                    }
                }
            }
            StringBuilder s1 = new StringBuilder();
            s1.append(chars);
            while(count >0){
                s1.insert(0,'1');
                count--;
            }
            return Integer.parseInt(s1.toString(),2);

        } else {
            return k;
        }
    }

    @Test
    public void tZ(){
        System.out.println(minimizeXor(1, 12));
    }
}
