package leecode;

/**
 * @author Hujf
 * @title: le984
 * @date 2020/9/22 0022上午 8:54
 * @description: TODO
 */
public class le984 {
    public static void main(String args[]) {
        System.out.println(strWithout3a3b(1,1));
    }

    public static String strWithout3a3b(int A, int B) {
        int total  = A+B;
        StringBuilder str = new StringBuilder();
        String s1="a" ;
        String s2="b" ;
        if(A<B){
           int a = A;
           A= B;
           B=a;
            s1 = "b";
            s2 = "a";
        }

       while(total>0){
           //如果只差不大于3且
           if(A-B>=0&&A<=B*2+2&&!str.toString().endsWith(s1+s1)) {
               str.append(s1);
               A--;
           }else if(!str.toString().endsWith(s2+s2)){
               str.append(s2);
               B--;
           }else{

           }
           total--;

       }

        return str.toString();
    }
}
