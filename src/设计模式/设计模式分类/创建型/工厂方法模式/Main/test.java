package 设计模式.设计模式分类.创建型.工厂方法模式.Main;

import org.junit.Test;
import 设计模式.设计模式分类.创建型.工厂方法模式.Button;
import 设计模式.设计模式分类.创建型.工厂方法模式.factory.ButtonFacoty;

import java.util.HashMap;

/**
 * @author Hujf
 * @title: test
 * @date 2021/3/1914:36
 * @description: TODO
 */
public class test {

    @Test
    public void t(){

        ButtonFacoty facoty = new ButtonFacoty();
        Button button = facoty.getSystem("window");
        button.onClick();
        Button button2 = facoty.getSystem("linux");
        button2.onClick();
    }
}
