package 多线程.并发包.atomic;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author hujf
 * @Date 2022/7/27 14:35
 * @Description TODO
 */
public class Curr {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> channelHandlerMap = new ConcurrentHashMap<>();
        channelHandlerMap.remove("1");
    }
}
