package 比赛;

import org.junit.Test;

/**
 * @author Hujf
 * @title: le5661替换最大时间
 * @date 2021/1/24 0024上午 10:33
 * @description: TODO
 */
public class le5661替换最大时间 {

    public String maximumTime(String time) {
         char []cs = time.toCharArray();
        char []cs2 = time.toCharArray();
          if(cs[0]=='?'&&cs[1]>='4'&&cs[1]<=9){
             cs2[0]='1';
         }else{
              if(cs[0]=='?') {
                  cs2[0] = '2';
              }
         }
         if(cs[1]=='?'&&(cs[0]=='2'||cs2[0]=='2')){
             cs2[1]='3';
         }else{
             if(cs[1]=='?') {
                 cs2[1] = '9';
             }
         }
         if(cs2[3]=='?'){
             cs2[3]='5';
         }
         if(cs2[4]=='?'){
             cs2[4]='9';
         }
         return String.valueOf(cs2);
    }

    @Test
    public void t(){
        maximumTime("??:3?");
    }
}
