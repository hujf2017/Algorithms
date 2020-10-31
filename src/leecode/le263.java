package leecode;

/**
 * @author Hujf
 * @title: le263
 * @date 2020/10/31 0031上午 9:33
 * @description: TODO
 */
public class le263 {
    public boolean isUgly(int num) {
        if(num==1){
            return true;
        }
        while(num%2==0){
            num = num/2;
        }
        while(num%3==0){
            num = num/3;
        }
        while(num%5==0){
            num = num/5;
        }
//        if(num!=1){
//            return false;
//        }
//        return true;
        return num==1;
    }
}
