import org.junit.Test;
import 比赛.OrderedStream;

import java.util.Stack;

/**
 * @author Hujf
 * @title: asdas
 * @date 2020/11/15 0015上午 10:57
 * @description: TODO
 */
public class asdas {
    @Test
    public void t() {
        OrderedStream o = new OrderedStream(9);
        o.insert(9, "fffff");
        o.insert(7, "ccccc");
        o.insert(6, "aaaaa");
        o.insert(4, "bbbbb");
        o.insert(2, "eeeee");
        o.insert(1, "ddddd");
        o.insert(5, "ggggg");
        o.insert(8, "hhhhh");
        o.insert(3, "mmmmm");
    }

    @Test
    public void  test(){
        //int [] a = new int[]{2,4,3,2,4,7,7,2,5,4};
        //int [] a = new int[]{5,6,8,5,10,7,12,6,6};
        int [] a = new int[]{7,11,6,6,7,9,5,10,6,3};
        double sum = 0;
        for(int i:a){
            sum+=Math.pow(i,2);
        }
        System.out.println(sum);
        System.out.println(sum*sum/20);
    }


    @Test
    public void test2(){
        int a =3;
        int b=3;
        while(b>0){
            a=a*b;
            b--;
        }
        System.out.println(a);
    }


    //字典序求排列中介数
    @Test
    public void test3(){
        String num = "839647521";
        StringBuilder sbf = new StringBuilder();
        char []s = num.toCharArray();
        //查找当前值的逆序
        for(int i=0;i<s.length;i++){
            int n=0;
            for(int j=i;j<s.length;j++){
                if(s[i]>s[j]){
                    n++;
                }
            }
            sbf.append(n);
        }
        System.out.println(sbf.toString());
    }

    //递增进位求排列中介数
    @Test
    public void test4(){
        String num = "839647521";
        char []s = num.toCharArray();
        int []s1 = new int[s.length];
        //查找当前值的逆序
        for(int i=0;i<s.length;i++){
            int n=0;
            for(int j=i;j<s.length;j++){
                if(s[i]>s[j]){
                    n++;
                }
            }
            int k = s[i]-'0';
            s1[k-1] = n;
        }
        for(int i=s1.length-1;i>=0;i--){
            System.out.print(s1[i]);
        }
    }


    //递增进位求序号的中介数
    @Test
    public void test5(){
        int num = 297191;
        StringBuilder stringBuilder = new StringBuilder();
        int i=2;
        while(num>0){
            int k=num%i;
            num = (num-k)/i;
            i++;
            stringBuilder.append(k);
        }
        System.out.print(stringBuilder.reverse().toString());
    }

    @Test
    public void t6(){
        int a =0;
        a++;
        System.out.print(a);
//        Stack<Character> e = new Stack();
//        e.add(')');
//        e.pop();
//        char a =')';
//        if(e.isEmpty()||a!=e.pop()){
//            System.out.print(a);
//            System.out.print(111);
//        }
    }

}
