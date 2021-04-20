package ali.test2;

import java.util.*;

/**
 * @author Hujf
 * @title: Main
 * @date 2021/4/1218:53
 * @description: TODO
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        while(num>0){
            num--;
            String s  = scan.nextLine();
            String s1[] = s.split(" ");
            String string = s1[0];
            int nums = Integer.valueOf(s1[2]);
            //先找所有的回文对

            if(nums>=string.length()-1){
                System.out.println(0);
            }
            Deque<Character> stack = new LinkedList<>();
            char ax[] = string.toCharArray();
            char lase;
            int count=0;
            int count22=0;
            boolean a = false;
            for(int i=0;i<ax.length-1;i++){
                if(stack.peekLast()==ax[i]){
                    stack.pollLast();
                    if(!a){
                        count++;
                        a=true;
                    }

                    count22++;
                }else{
                    stack=new LinkedList<>() ;
                    a=false;
                }
            }
            System.out.println((string.length()-count22-count)/2);
        }
    }
}
