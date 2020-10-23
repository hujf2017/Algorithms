package 比赛;

/**
 * @author Hujf
 * @title: 速算机器
 * @date 2020/9/12 0012下午 3:41
 * @description: TODO
 */
public class 速算机器 {
    public int calculate(String s) {
        int x =1;
        int y =0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                x =  2 * x + y;
            }else{
                y = 2 * y + x;
            }
        }
        return x+y;
    }

}
