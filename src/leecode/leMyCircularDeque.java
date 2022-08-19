package leecode;

/**
 * @Author hujf
 * @Date 2022/8/15 9:39
 * @Description TODO
 */
public class leMyCircularDeque {

    int []num;

    int start ;
    int end ;
    int k;
    int count =0;
    public leMyCircularDeque(int k) {
        num = new int[k];
        this.k= k;
        start =0;
        end=0;
    }

    public boolean insertFront(int value) {
        if(count<k){
            count++;
            num[start] = value;
            start = start-1 <0?start-1 +k:start-1;
            return true;
        }else {
            return false;
        }
    }

    public boolean insertLast(int value) {
        if(count<k){
            count++;
            num[end] = value;
            end = (end+1)%k;
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteFront() {
        if(count>0) {
            start =(start+1)%k;
            num[start] = 0;
            count--;
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteLast() {
        if(count>0) {
            num[end] = 0;
            end = (end-1)<0?(end-1+k):end-1;
            count--;
            return true;
        }else {
            return false;
        }
    }

    public int getFront() {
        if(count==0){
            return -1;
        }
        return num[(start+1)%k];
    }

    public int getRear() {
        if(count==0){
            return -1;
        }
        return num[end];
    }

    public boolean isEmpty() {
        if(count==0){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if(count==k){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        leMyCircularDeque circularDeque= new leMyCircularDeque(3);
        circularDeque.insertLast(1);			        // 返回 true
        circularDeque.insertLast(2);			        // 返回 true
        circularDeque.insertFront(3);			        // 返回 true
        circularDeque.insertFront(4);			        // 已经满了，返回 false
        circularDeque.getRear();  				// 返回 2
        circularDeque.isFull();				        // 返回 true
        circularDeque.deleteLast();			        // 返回 true
        circularDeque.insertFront(4);			        // 返回 true
        System.out.println(circularDeque.getRear());                // 返回 4
    }
}
