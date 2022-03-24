package leecode;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/3/18 16:57
 * @Description TODO
 */
public class le008 {
    public int myAtoi(String s) {
//        int maxValue = Integer.MAX_VALUE;
//        int minValue = Integer.MIN_VALUE;
//        s = s.trim();
//        char[] chars = s.toCharArray();
//        StringBuilder sdb = new StringBuilder();
//        boolean sx = false;
//        boolean sx2 = false;
//        boolean sx3 = false;
//        for(char x:chars){
//            if((x>=48&&x<=57)){
//                sx3 =true;
//                if(x==48&&!sx){
//                    continue;
//                }
//                sdb.append(x);
//                sx = true;
//            }else if(x==45||x==43){
//                if(sx2||sx3){
//                    break;
//                }
//                sdb.append(x);
//                sx2 = true;
//            }else {
//               break;
//            }
//        }
//
//        if(sdb.length()==0||sx == false){
//            return  0;
//        }
//        String trim = sdb.toString();
//        if(trim.length()>12){
//            if(trim.startsWith("-")){
//                return minValue;
//            }else {
//                return maxValue;
//            }
//        }
//        if(Long.parseLong(trim)>maxValue){
//            return maxValue;
//        }else if(Long.parseLong(trim)<minValue){
//            return minValue;
//        }else{
//            return Integer.valueOf(trim);
//        }

        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        s = s.trim();
        char[] chars = s.toCharArray();
        StringBuilder sdb = new StringBuilder();

        boolean hasadd = false;
        for(char x:chars){
            if(x==45){
                if(hasadd){
                    continue;
                }
                sdb.append("-");
                hasadd =true;
            }else if(x==43) {
                sdb.append("+");
                hasadd =true;
            }else{
                if((x>=48&&x<=57)){

                }
            }
        }
        return 0;
    }

    @Test
    public void t(){
//        String s ="-";
//        for(char x:s.toCharArray()){
//            int num = x;
//            System.out.println(num);
//        }
       myAtoi("\"00000-42a1234\"");
     //  System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
    }
}
