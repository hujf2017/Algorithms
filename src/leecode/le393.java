package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/10/19 17:27
 * @Description TODO
 */
public class le393 {
    public boolean validUtf8(int[] data) {

        for (int i = 0; i < data.length; i++) {
            //每次都找一个
            String s = Integer.toBinaryString(data[i]);
            if (s.startsWith("0")||s.length()<8) {
                    if(!panduan(0,i,data)){
                        return false;
                    }
            } else if (s.startsWith("110")) {
                if(!panduan(1,i,data)){
                    return false;
                }
                i+=1;
            } else if (s.startsWith("1110")) {
                if(!panduan(2,i,data)){
                    return false;
                }
                i+=2;
            } else if(s.startsWith("11110")){
                if(!panduan(3,i,data)){
                    return false;
                }
                i+=3;
            }else {
                return false;
            }
        }

        return true;
    }

    private boolean panduan(int count,int i,int[]data) {
        int num=1;
        while (num <= count) {
            if (i+num>=data.length||! Integer.toBinaryString(data[i + num]).startsWith("10")||Integer.toBinaryString(data[i + num]).length()<8) {
                return false;
            }
            num++;
        }
        return true;
    }

    @Test
    public void t(){
        System.out.println(validUtf8(new int[]{248,130,130,130
}));
    }

}
