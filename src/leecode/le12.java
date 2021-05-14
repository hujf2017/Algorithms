package leecode;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le12
 * @date 2021-05-14 9:29
 * @description: TODO
 */
public class le12 {
    StringBuilder builder = new StringBuilder();
    public String intToRoman(int num) {
        calc(num);
        return builder.toString();
    }

    private void calc(int num) {
        if(num==0){
            return ;
        }
        int num1 = num/1000;
        num = num%1000;
        for(int i=0;i<num1;i++){
            builder.append("M");
        }
        String s = del(num);
        builder.append(s);
    }

    private String del(int num) {
        StringBuilder bs = new StringBuilder();
        //计算百位
        int hund = num/100;
        //9
        if(hund>8){
            bs.append("CM");
        }else if(hund<4){
            for(int i=0;i<hund;i++){
                bs.append("C");
            }
        }else{
            switch (hund){
                case 4: bs.append("CD");break;
                case 5: bs.append("D");break;
                case 6: bs.append("DC");break;
                case 7: bs.append("DCC");break;
                case 8: bs.append("DCCC");break;
            }
        }

        //计算十位
        hund = (num/10)%10;
        //9
        if(hund>8){
            bs.append("XC");
        }else if(hund<4){
            for(int i=0;i<hund;i++){
                bs.append("X");
            }
        }else{
            switch (hund){
                case 4: bs.append("XL");break;
                case 5: bs.append("L");break;
                case 6: bs.append("LX");break;
                case 7: bs.append("LXX");break;
                case 8: bs.append("LXXX");break;
            }
        }

        //计算个位
        hund =num %10;
        //9
        if(hund>8){
            bs.append("IX");
        }else if(hund<4){
            for(int i=0;i<hund;i++){
                bs.append("I");
            }
        }else{
            switch (hund){
                case 4: bs.append("IV");break;
                case 5: bs.append("V");break;
                case 6: bs.append("VI");break;
                case 7: bs.append("VII");break;
                case 8: bs.append("VIII");break;
            }
        }
        return bs.toString();
    }

    @Test
    public void t(){
        System.out.println(intToRoman(1994));
    }
}
