package 基础.fin;

/**
 * @author Hujf
 * @title: FinalTest
 * @date 2021-09-08 15:29
 * @description: TODO
 */
public class FinalTest {
    public static void main(String[] args) {
        int a =10;
        get(a);
        System.out.println(a);
        get2(a);
        System.out.println(a);

        Ttt ttt = new Ttt(10);
        System.out.println(ttt.getNum());
        get3(ttt);
        System.out.println(ttt.getNum());
    }

    private static void get3(Ttt ttt) {
        ttt.setNum(11);
    }

    private static void get2(final int a) {
        //wu法将值赋给 final 变量 'a'
        //a=12;
    }

    private static void get(int a) {
        a = 11;
    }
}
class Ttt{
    public Ttt(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private  int num ;
}
