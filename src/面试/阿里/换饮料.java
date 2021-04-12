package 面试.阿里;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 换饮料
 * @date 2021/4/1214:00
 * @description: TODO
 */
public class 换饮料 {

    public int change(int n){
        int gai = 0;
        int ping = 0;
        int total = 0;
        total = n/3;
        gai =total;
        ping =total;


        while(gai>=4||ping >=2){
            if(gai>=4){
                int tmp = gai/4;
                total+=tmp;
                gai =tmp+gai%4;
                ping = ping+tmp;
            }
            if(ping>=2){
                int tmp = ping /2;
                total+=ping +tmp;
                gai = tmp+gai;
                ping = ping %2+tmp;
            }
        }
        return total;
    }

    @Test
    public void t(){
        change(30);
    }
}
