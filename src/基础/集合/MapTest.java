package 基础.集合;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Hujf
 * @title: MapTest
 * @date 2021-10-18 10:18
 * @description: TODO
 */
public class MapTest {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.setId(1+"");
        s1.setName("hujf");

        s2.setId(1+"");
        s2.setName("hujf");

        Map map = new HashMap();
        map.put(s1,"1");
        map.put(s2,"1");


        Map map2 = new HashMap();

        Iterator<Map.Entry<Student,String>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Student,String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
            map2.put(next.getKey(),"2");
        }
    }

    static class Student{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return Integer.parseInt(id);
        }
    }

    @Test
    public void test(){
        String s  ="Aa";
        String s2 = "BB";

        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());

        System.out.println(s.equals(s2));

        Map m = new HashMap(2);
        m.put(s,"1");
        m.put(s,"2");
        m.put(s2,"3");
        System.out.println(m.size());
        Iterator<Map.Entry<String,String>> iterator = m.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }


    }
}
