package 设计模式.六大原则.开闭原则.impl;

import 设计模式.六大原则.开闭原则.Pay;

/**
 * @author Hujf
 * @title: ZhifubaoPayImpl
 * @date 2021/3/1516:37
 * @description: TODO
 */
public class ZhifubaoPayImpl implements Pay {
    @Override
    public void pay() {
        System.out.println("使用支付宝支付");
    }
}
