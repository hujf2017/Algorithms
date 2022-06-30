package leecode;

/**
 * @Author hujf
 * @Date 2022/6/30 9:27
 * @Description
 */
public class le1175 {

    static int nums =1000000007;

    public int numPrimeArrangements(int n) {
        int []num = new int[n+1];
        num[1]=1;
        for(int i=2;i<=n;i++){
            int count=2;
            while(i*count<=n){
                num[i*count]=1;
                count++;
            }
        }

        int zhishu = 0;
        int heshu = 0;
        for(int i=1;i<=n;i++){
            if(num[i]==1){
                heshu++;
            }else{
                zhishu++;
            }
        }

        //计算全排列
        long num1 =  calc(heshu);
        long num2 =  calc(zhishu);
        int l = (int) ((num1 * num2)%nums);
        return l;
    }

    private long calc(int heshu) {
        long a = 1;
        while(heshu>1){
            a= (a*heshu)%nums;
            heshu--;
        }

        return a;
    }


    public void t(){

    }
}
