package 面试;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 找到重复的数
 * @date 2021-05-28 15:02
 * @description: TODO
 */
public class 找到重复的数 {


    public int findNum(int [] a){
        int num = a[0];
        for(int i=1;i<a.length;i++){
            num^=a[i];
        }
       return num;
    }
    @Test
    public void t(){
        findNum(new int[]{1,2,3,3,6,7,11,9,14});
    }
}
