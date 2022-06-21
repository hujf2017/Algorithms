package leecode;

/**
 * @Author hujf
 * @Date 2022/6/20 9:17
 * @Description TODO
 */
public class le715 {

    int []range;
    public le715() {
        range = new int[1000000001];
    }

    public void addRange(int left, int right) {
        for(int i=left ;i<right;i++){
            range[i] = 1;
        }
    }

    public boolean queryRange(int left, int right) {
       return (range[left]==1||range[left+1]==1||range[left-1]==1)&&(range[right]==1||range[right+1]==1||range[right-1]==1);
    }

    public void removeRange(int left, int right) {
        for(int i=left ;i<right;i++){
            range[i] = 0;
        }
    }
}
