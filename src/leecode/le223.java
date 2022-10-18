package leecode;

/**
 * @Author hujf
 * @Date 2022/10/18 10:11
 * @Description TODO
 */
public class le223 {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int s1 = (ax2 - ax1)*(ay2 - ay1);
        int s2 = (bx2 - bx1)*(by2 - by1);

        int doubX = Math.min(ax2,bx2)- Math.max(ax1,bx1);

        int doubY = Math.min(by2,ay2)- Math.max(by1,ay1);

        int s = doubX*doubY;
        return s1+s2 -s;
    }
}
