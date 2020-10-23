import common.ActivityType;
import org.junit.Test;
import 比赛.ParkingSystem;

/**
 * @author Hujf
 * @title: test
 * @date 2020/9/23 0023下午 2:44
 * @description: TODO
 */
public class test {


    @Test
    public void aaa(){
        String a = "1";
        String s = ActivityType.getDescByCode(a);
        System.out.println(s);
    }


    @Test
    public void as(){
        ParkingSystem a = new ParkingSystem(1,1,0);
        System.out.println(a.addCar(1));
        System.out.println(a.addCar(2));
        System.out.println(a.addCar(3));
    }
}
