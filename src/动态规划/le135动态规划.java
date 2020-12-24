package 动态规划;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le135动态规划
 * @date 2020/12/24 0024上午 9:04
 * @description: TODO
 */
public class le135动态规划 {
    public int candy(int[] ratings) {
        int last =1;
        int local = 1;
        int sum = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]==ratings[i-1]){
                local =1;
                sum+=1;
                last=1;
            }else{
                if(ratings[i]<ratings[i-1]){
                    if(last==1){
                        sum+=(local+1);
                        last =1;
                        local++;
                    }else{
                        sum+=1;
                        last =1;
                        local=1;
                    }
                }else{
                    last++;
                    sum+=last;
                    local=1;
                }
            }
        }
        return sum;
    }


    @Test
    public void t(){
        candy(new int[]{1,2,3,1,0});
    }
}
