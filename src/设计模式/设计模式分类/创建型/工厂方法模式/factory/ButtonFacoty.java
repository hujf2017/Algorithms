package 设计模式.设计模式分类.创建型.工厂方法模式.factory;

import 设计模式.设计模式分类.创建型.工厂方法模式.Button;
import 设计模式.设计模式分类.创建型.工厂方法模式.LinuxButton;
import 设计模式.设计模式分类.创建型.工厂方法模式.WindowsButton;

/**
 * @author Hujf
 * @title: ButtonFacoty
 * @date 2021/3/1914:33
 * @description: TODO
 */
public class ButtonFacoty {

    public Button getSystem(String btype){
        if(btype.equals("window")){
            return new WindowsButton();
        }else{
            return new LinuxButton();
        }
    }
}
