package leecode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Hujf
 * @title: le179
 * @date 2021/4/128:13
 * @description:
 */
public class le179 {
    int[] nums = new int[]{0,0};

    public String largestNumber(int[] nums) {
        IntStream intStream = Arrays.stream(nums);
        Stream<Integer> boxed = intStream.boxed();
        Stream<String> stream =boxed.map(Objects::toString);
        Stream<String> sorted = stream.sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        List<String> list = sorted.collect(Collectors.toList());
        StringBuffer buf =new StringBuffer();
        if("0".equals(list.get(0))){
            return "0";
        }
        for (String  s : list) {

            buf.append(s);
        }
        return buf.toString();
    }

    @Test
    public void t() {
        largestNumber(nums);
    }
}
