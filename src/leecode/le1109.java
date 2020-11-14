package leecode;

/**
 * @author Hujf
 * @title: le1109
 * @date 2020/11/14 0014下午 3:10
 * @description: TODO
 */
public class le1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int []a = new int[n];
        for(int i=0;i<bookings.length;i++ ){
            int b[] =bookings[i];
            for(int j=b[0];j<=b[1];j++){
                a[j-1]+=b[2];
            }
        }
        // int count =0;
        // for(int k :a){
        //     if(k>0){
        //         l[count]=k;
        //         count++;
        //     }

        // }
        return a;
    }
}
