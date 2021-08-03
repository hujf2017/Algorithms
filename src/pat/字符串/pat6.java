package pat.字符串;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Hujf
 * @title: pat6
 * @date 2021-08-03 14:14
 * @description: 找到第一个进来的 和最后一个走的
 */
public class pat6 {

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buf = new BufferedReader(in);
        int num = Integer.parseInt(buf.readLine());
        String fristTime = "23:59:59";
        String lastTime = "00:00:00";
        String fristP = null;
        String lastP = null;
        while (num > 0) {
            String[] s = buf.readLine().split(" ");
            if (fristTime.compareTo(s[1]) > 0) {
                fristTime = s[1];
                fristP = s[0];
            }

            if (lastTime.compareTo(s[2]) < 0) {
                lastTime = s[2];
                lastP = s[0];
            }
            num--;
        }
        System.out.println(fristP + " " + lastP);
    }
}

//
//import java.io.BufferedReader;
//        import java.io.IOException;
//        import java.io.InputStreamReader;
//
//public class Main {
//
//    /**
//     * @param args
//     *            2019-12-25下午2:27:46
//     * @throws IOException
//     */
//    public static void main(String[] args) throws IOException {
//        int min = 24*60*60;
//        int max = 0;
//        String s1 = null;
//        String s2 = null;
//        InputStreamReader in = new InputStreamReader(System.in);
//        BufferedReader buf = new BufferedReader(in);
//        int num = Integer.valueOf(buf.readLine());
//        for(int i=0;i<num;i++){
//            String str[] = buf.readLine().split(" ");
//            //	System.out.println(str[1].substring(6, 8));
//            int come = Integer.valueOf(str[1].substring(0, 2))*3600+Integer.valueOf(str[1].substring(3, 5))*60+Integer.valueOf(str[1].substring(6, 8));
//            if(come<min){
//                min = come;
//                s1 = str[0];
//            }
//            int back = Integer.valueOf(str[2].substring(0, 2))*3600+Integer.valueOf(str[2].substring(3, 5))*60+Integer.valueOf(str[2].substring(6, 8));
//            if(back>max){
//                max = back;
//                s2 = str[0];
//            }
//        }
//        System.out.println(s1+" "+s2);
//
//
//    }
//
//}
