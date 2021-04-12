package 基础.stream编程.Main;

import 基础.stream编程.LambdaInterface.NoReturnMultiParam;

/**
 * @author Hujf
 * @title: TestLambda
 * @date 2021/4/129:56
 * @description: TODO
 */
public class TestLambda {
    public static void main(String[] args) {

        //多参数无返回
        NoReturnMultiParam noReturnMultiParam = (int a,int b)->{
            System.out.print(a+b);
        };
        noReturnMultiParam.method(1,2);
    }
}
