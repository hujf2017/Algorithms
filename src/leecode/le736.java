package leecode;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author hujf
 * @Date 2022/7/6 9:27
 * @Description TODO
 */
public class le736 {
    public int evaluate(String expression) {
        String[] ss = expression.split(" ");
        String [] x =getgroup(expression);


        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();
        StringBuilder sbd = new StringBuilder();
        for (int i=0;i<ss.length;i++) {
            String str = ss[i];
            if (str.startsWith("(")) {
                list.add("(");
                list2.add(str.substring(1));
                sbd = new StringBuilder();
            } else if (str.endsWith(")")) {
                list.removeLast();
            }
            sbd.append(str);
        }

        return  1;

    }

    private String[] getgroup(String expression) {
        String[] substring = expression.split("\\(");

        return substring;
    }


    @Test
    public void t(){
        evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))");
    }
}
