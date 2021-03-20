package 设计模式.设计模式分类.创建型.建造者模式.Main;

import org.junit.Test;
import 设计模式.设计模式分类.创建型.建造者模式.Build.HouseBuilder;
import 设计模式.设计模式分类.创建型.建造者模式.Build平房;
import 设计模式.设计模式分类.创建型.建造者模式.Build豪宅;
import 设计模式.设计模式分类.创建型.建造者模式.Director.HouseDirector;

/**
 * @author Hujf
 * @title: Main
 * @date 2021/3/2013:57
 * @description: TODO
 */
public class Main {
    @Test
    public void t(){
        String s = "我是土豪";
        get(s);
        String s1 = "我是老百姓";
        get(s1);
    }

    private void get(String s) {
        if(s.equals("我是土豪")){
            Build豪宅 build豪宅 = new Build豪宅();
            HouseDirector director = new HouseDirector(build豪宅);
            director.construct();
        }else{
            Build平房 build平房 = new Build平房();
            HouseDirector houseDirector = new HouseDirector(build平房);
            houseDirector.construct();
        }
    }


}
