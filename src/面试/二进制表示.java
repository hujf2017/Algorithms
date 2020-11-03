package 面试;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 二进制表示
 * @date 2020/11/3 0003下午 4:35
 * @description: TODO
 */
public class 二进制表示 {
    public String printBin(double num) {
        //0.5 0.25 0.125 0.0625 0.0
        double a = 0.5;
        StringBuffer asad = new StringBuffer("0.");
//        for(int i=0;i<32;i++){
//            if(num==0){
//                return asad.toString();
//            }
//            if(num>=a){
//                num = num-a;
//                a= a/2;
//                asad.append(1);
//            }else{
//                a= a/2;
//                asad.append(0);
//            }
//        }
        while(num != 0) {
            num *= 2;
            if(num >= 1) {
                asad.append(1);
                num -= 1;
            }else {
                asad.append(0);
            }
            if(asad.length() > 32) {
                return "ERROR";
            }
        }
        return asad.toString();
    }

    private void calc(double num, double a) {
        if(num>a){
            calc(num-a,a/2);
        }else{
            calc(num,a/2);
        }
    }
    @Test
    public void t(){
        printBin(0.1);
    }
}
