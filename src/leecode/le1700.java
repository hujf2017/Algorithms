package leecode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author hujf
 * @Date 2022/10/19 9:10
 * @Description TODO
 */
public class le1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int count = 0;
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != sandwiches[count]) {
                deque.add(students[i]);
            } else {
                count++;
            }
        }
        int left = 0;
        while (deque.size() > 0 && left < deque.size()) {
            Integer poll = deque.poll();
            if (poll != sandwiches[count]) {
                deque.add(poll);
                left++;
            } else {
                left = 0;
                count++;
            }
        }
        return deque.size();
    }

    @Test
    public void t() {
        countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1});
    }
}
