package 设计模式.设计模式分类.结构型.生成器;

public class Pizza {
    private String parts;

    public void setParts(String parts){
        this.parts=parts;
    }

    @Override
    public String toString(){
        return this.parts;
    }
}
