import leecode.le703;
import org.junit.Test;

/**
 * @author Hujf
 * @title: sum
 * @date 2020/10/18 0018上午 11:02
 * @description: TODO
 */
public class sum {
    //45851789    14864282 11834989 18804686 01656885
    //                              04686188 01656885
    @Test
    public void test(){
        String a = "07070707";

        String b ="00646784";
        for(int i=0;i<8;i++){
            int a1 =Integer.valueOf(a.charAt(i))-48;
            int b1 = Integer.valueOf(b.charAt(i))-48;
            System.out.print((a1+b1)%10);
        }

    }

    @Test
    public void t(){
        le703 aasd = new le703(1, new int[]{});
        System.out.println(aasd.add(-3));
        System.out.println(aasd.add(-2));
        System.out.println(aasd.add(-4));
        System.out.println(aasd.add(0));
        System.out.println(aasd.add(4));
    }
}
