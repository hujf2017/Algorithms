package pat.字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Hujf
 * @title: pat7
 * @date 2021-08-03 14:41
 * @description: If all the K numbers are negative, then its maximum sum is defined to be 0, and you are supposed to output the first and the last numbers of the whole sequence.
 */
public class pat7 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        int num = Integer.parseInt(reader.readLine());
        if (num == 0) {
            System.out.println(0 + " " + 0 + " " + 0);
        } else {
            String[] a = reader.readLine().split(" ");
            int sum = 0;
            int best = 0;
            int bstart = Integer.parseInt(a[0]);
            int bend = Integer.parseInt(a[0]);
            int count = 0;
            int findex=0;

            for (int i = 0; i < num; i++) {
                if (Integer.parseInt(a[i]) < 0) {
                    count++;
                }
                sum += Integer.parseInt(a[i]);
                if (sum > best) {
                    best = sum;
                    bstart = Integer.parseInt(a[findex]);
                    bend = Integer.parseInt(a[i]);
                }
                if (sum < 0) {
                    sum = 0;
                    if (i < num - 1) {
                        findex = i+1;
                    }
                }
            }
            if (count == a.length) {
                System.out.println(0 + " " + a[0] + " " + a[count - 1]);
            } else {
                System.out.println(best + " " + bstart + " " + bend);
            }
        }
    }
}


//    public static void main(String[] args) throws NumberFormatException,
//            IOException {
//        InputStreamReader in = new InputStreamReader(System.in);
//        BufferedReader buf = new BufferedReader(in);
//        int num = Integer.valueOf(buf.readLine());
//        int sum = 0;
//        int start = 0;
//        int end = 0;
//        int max = 0;
//        int start1 = 0;
//        int end1 = 0;
//        boolean a = false;
//        String[] nums = buf.readLine().split(" ");
//        while (end < num) {
//            if(Integer.valueOf(nums[end])>=0){
//                a=true;
//            }
//            sum = sum + Integer.valueOf(nums[end]);
//            if (sum > max) {
//                max = sum;
//                start1 = start;
//                end1 = end;
//            }
//            if (sum < 0) {
//                sum = 0;
//                start = end;
//            }
//            end++;
//        }
//        if (a == false) {
//            System.out.println(max + " " + nums[0] + " "
//                    + nums[end-1]);
//        } else {
//            if (Integer.valueOf(nums[start1]) < 0&&Integer.valueOf(nums[end1]) > 0) {
//                System.out.println(max + " " + nums[start1 + 1] + " "
//                        + nums[end1]);
//            } else if(Integer.valueOf(nums[end1]) < 0){
//                System.out.println(max + " " + nums[start1+1 ] + " "
//                        + nums[end1+1]);
//            }else{
//                System.out.println(max + " " + nums[start1] + " " + nums[end1]);
//            }
//        }
//
//    }