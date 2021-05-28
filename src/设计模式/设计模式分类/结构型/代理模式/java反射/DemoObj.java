package 设计模式.设计模式分类.结构型.代理模式.java反射;




/**
 * @author Hujf
 * @title: DemoObj
 * @date 2021-05-27 21:12
 * @description: TODO
 */
public class DemoObj {
    private String key;
    public static String code;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

   public DemoObj(String key){
        this.key=key;
   }

    public DemoObj(){
    }
}
