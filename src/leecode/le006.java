package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/3/18 9:47
 * @Description TODO
 */
public class le006 {

    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        int k = s.length()/(2*numRows - 2);
        int num = (k+1)*(numRows-1);
        int[][] nu = new int[numRows][num];
        char[] chars = s.toCharArray();
        int index = 0;
        for (int i = 0; i < num; i++) {
            if(index==chars.length){
                break;
            }
            if(i%(numRows-1)==0){
                for(int m=0;m<numRows;m++){
                    nu[m][i]  = chars[index++];
                    if(index==chars.length){
                        break;
                    }
                }
            }else{
                int left = i%(numRows-1);
                nu[numRows-1-left][i] = chars[index++];
            }


        }
        StringBuilder sbd = new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<num;j++){
                if(nu[i][j]!=0){
                    sbd.append((char)nu[i][j]);
                }

            }
        }

        return sbd.toString() ;
    }


    @Test
    public void t(){
        convert("ABCD",4);
    }
}
