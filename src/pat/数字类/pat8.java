package pat.数字类;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Hujf
 * @title: pat8
 * @date 2021-08-04 9:46
 * @description: 电梯  开始在0层 上一层 6秒 下一层4秒
 */
public class pat8 {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(in);
        String []s = buf.readLine().split(" ");
        int num = Integer.parseInt(s[0]);
        int sum =num*5;
        int local = 0;
        for(int i=1;i<num+1;i++){
            int flow = Integer.parseInt(s[i]);
            if(flow>local){
                sum+=(flow-local)*6;
            }else{
                sum+=(local-flow)*4;
            }
            local = flow;
        }
        System.out.println(sum);
    }

//    public static void main(String[] args) throws IOException {
//        InputStreamReader in = new InputStreamReader(System.in);
//        BufferedReader buf = new BufferedReader(in);
//        String a[] = buf.readLine().split(" ");
//        int num = Integer.valueOf(a[0]);
//        int start = 0;
//        int sum = 0;
//        for (int i = 0; i < num; i++) {
//            int s = start - Integer.valueOf(a[i+1]);
//            if (s < 0) {
//                sum = sum - s * 6;
//            } else {
//                sum = sum + s * 4;
//            }
//            start = Integer.valueOf(a[i+1]);
//        }
//        System.out.print(sum+num*5);
//    }
}
