package leecode;

import org.junit.Test;

import java.util.*;

/**
 * @Author hujf
 * @Date 2022/10/11 10:23
 * @Description TODO
 */
public class le2434 {
    StringBuilder stringBuilder = new StringBuilder();

    public String robotWithString(String s) {
        char[] chars = s.toCharArray();
        char[] min = new char[chars.length];
        char minc = chars[chars.length - 1];
        for (int i = chars.length - 1; i > 0; i--) {
            min[i - 1] = (char) Math.min(chars[i], minc);
            minc = min[i - 1];
        }
        Deque<Character> deque = new LinkedList();
        //从前往后 如果小于最小值
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= min[i]) {
                stringBuilder.append(chars[i]);
                //判断后面的最小值 是否比 队列中的上一个小
                while(deque.size()>0){
                    Character character = deque.peekLast();
                    if(character<=min[i]){
                        stringBuilder.append(deque.pollLast());
                    }else {
                        break;
                    }
                }
            } else {
                deque.add(chars[i]);
            }
        }

        while(deque.size()>0){
            stringBuilder.append(deque.pollLast());
        }

        return stringBuilder.toString();
    }


    @Test
    public void t() {
        //bdsabfeuiakshjhf bdsabfeubakshjhf ""vzhofnpo""
        robotWithString("vzhofnpo");
    }
}
