import common.ActivityType;
import org.junit.Test;
import 比赛.ParkingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void te(){
        List a = new ArrayList();
        a.add(1);


        Map<Integer,Integer> m = new HashMap<>();
        m.put(1,m.getOrDefault(1,0));
        for(Map.Entry<Integer,Integer> e :m.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
    }



}
