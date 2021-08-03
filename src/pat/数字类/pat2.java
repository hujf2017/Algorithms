package pat.数字类;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Hujf
 * @title: pat2
 * @date 2021-07-15 10:25
 * @description: 计算多项式 给出多少项  以及系数和知乎， 所以需要进行计算
 *
 *
 * 易错点
 * 1.保留小数
 * 2. 零问题  两数相加后等于 0  需要排除掉
 *
 */
public class pat2 {

    //    public static void main(String[] args) throws IOException {
//        InputStreamReader reader = new InputStreamReader(System.in);
//        BufferedReader reader1 = new BufferedReader(reader);
//        String []s1  = reader1.readLine().split(" ");
//        String []s2 = reader1.readLine().split(" ");
//        int i1 = 1;
//        int i2 = 1;
//        StringBuilder  sb = new StringBuilder();
//        int count =0;
//        while(i1<s1.length&&i2<s2.length){
//            if(Integer.parseInt(s1[i1])>Integer.parseInt(s2[i2])){
//                sb.append(" "+s1[i1]+" "+(s1[i1+1]));
//                i1+=2;
//            }else if (Integer.parseInt(s1[i1])<Integer.parseInt(s2[i2])){
//                sb.append(" "+s2[i2]+" "+(s2[i2+1]));
//                i2+=2;
//            }else {
//                double num2 =Double.parseDouble(s1[i1+1])+Double.parseDouble(s2[i2+1]);
//                sb.append(" "+s1[i1]+" "+num2);
//                i1+=2;
//                i2+=2;
//            }
//            count++;
//        }
//        while(i1<s1.length){
//            sb.append(" "+s1[i1]+" "+(s1[i1+1]));
//            i1+=2;
//            count++;
//        }
//        while(i2<s2.length){
//            sb.append(" "+s2[i2]+" "+(s2[i2+1]));
//            i2+=2;
//            count++;
//        }
//        StringBuilder  sb2 = new StringBuilder(count+"");
//        sb2.append(sb);
//        s1 = sb2.toString().split(" ");
//        int len =0;
//
//    }
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader reader1 = new BufferedReader(reader);
        String[] s1 = reader1.readLine().split(" ");
        String[] s2 = reader1.readLine().split(" ");
        double [] len  = new double[1001];
        int i1=1;
        while(i1<s1.length){
            len[Integer.parseInt(s1[i1])] += Double.parseDouble(s1[i1+1]);
            i1+=2;
        }
        int i2=1;
        int count =0;
        while(i2<s2.length){
            if(len[Integer.parseInt(s2[i2])]!=0){
                count++;
            }
            len[Integer.parseInt(s2[i2])] += Double.parseDouble(s2[i2+1]);
            if(len[Integer.parseInt(s2[i2])]==0){
                count++;
            }
            i2+=2;
        }

        System.out.print((s1.length+s2.length-2)/2-count);
        for(int i=1000;i>=0;i--){
            if(len[i]!=0) {
                System.out.printf(" %d %.1f", i, len[i]);
            }
        }
        System.out.println();
    }
}
