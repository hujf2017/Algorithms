package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/14 14:39
 * @Description TODO
 */
public class le43 {
    public String multiply(String num1, String num2) {
        int [] arr= new int [20];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                int x= num2.charAt(j)-'0';
                int y= num1.charAt(i)-'0';
                int num= x*y;
                int local = num1.length()-i-1+num2.length()-j;
                int numx1 = num/10;
                int numx2 = num%10;
                int count =0;
                arr[arr.length-local] +=numx2;
                if (arr[arr.length - local] >= 10) {
                    arr[arr.length-local] = arr[arr.length-local]%10;
                    count=1;
                }
                arr[arr.length-local-1] +=numx1+count;

                int count3=1;
                while(arr[arr.length-local-count3]>=10){
                    arr[arr.length-local-count3] = arr[arr.length-local-count3]%10;
                    count3++;
                    arr[arr.length-local-count3] += 1;
                }

            }
        }
        StringBuilder sbd = new StringBuilder();
        boolean zero = true;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0&&zero){
                continue;
            }
            zero = false;
            sbd.append(arr[i]);
        }
        if(zero){
            return "0";
        }
        return sbd.toString();
    }

    @Test
    public void t(){
        multiply("123456789","987654321");
    }
}
