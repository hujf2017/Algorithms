package leecode;

/**
 * @Author hujf
 * @Date 2022/10/11 10:11
 * @Description TODO
 */
public class le2433 {
    public int[] findArray(int[] pref) {
        int first = pref[0];
        for (int i = 1; i < pref.length; i++) {
           int tmp = pref[i];
            pref[i] = first^pref[i];
            first = tmp;
        }
        return pref;
    }


    public static void main(String[] args) {
        int num1 = 7;
        int num2 = 5;
        //num3为1的地方  num1 和num2 不同
        int num3 = 2;
        //不同的地方为1

        System.out.println(0^3);
    }
}
