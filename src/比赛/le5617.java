package 比赛;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le5617
 * @date 2020/12/6 0006上午 11:02
 * @description: TODO
 */
public class le5617 {

    public String interpret(String command) {
        String s = command.replaceAll("\\("+"al"+"\\)","al");
        s = s.replaceAll("\\(\\)","o");
        return s;
    }

    @Test
    public void t(){
        interpret("G()()()()(al)");

    }}
