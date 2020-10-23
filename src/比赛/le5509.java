package 比赛;

/**
 * @author Hujf
 * @title: le5509
 * @date 2020/9/6 0006上午 11:39
 * @description: TODO
 */
public class le5509 {

    public static void main(String args[]){
       String  s = "aaabbbabbbb";
        int []cost = {3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(minCost(s,cost));
    }
    public static int minCost(String s, int[] cost) {
        int allCost = 0;
        char ch []= s.toCharArray();
        for(int i=0;i<ch.length-1;i++){
           int j=i+1;
           if(ch[i]==ch[j]){
               if(cost[i]>cost[j]){
                   allCost +=cost[j];
                   cost[j] = cost[i];
               }else{
                   allCost +=cost[i];
               }

           }

        }
        return allCost;
    }
}
