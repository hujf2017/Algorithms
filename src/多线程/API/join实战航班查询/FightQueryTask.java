package 多线程.API.join实战航班查询;

import java.util.List;

/**
 * @author Hujf
 * @title: FightQueryTask
 * @date 2020/11/12 0012上午 12:36
 * @description: TODO
 */
public class FightQueryTask extends Thread implements FightQuery{
    private final String origin;

    private final String destination;

    public FightQueryTask(String origin,String destination) {
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public List<String> get() {
        return null;
    }




}
