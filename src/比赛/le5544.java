package 比赛;

/**
 * @author Hujf
 * @title: le5544
 * @date 2020/10/18 0018上午 10:46
 * @description: TODO
 */
public class le5544 {
    public String findLexSmallestString(String s, int a, int b) {
        int len = s.length();
        String tmp=""  ;
        for(int i=0;i<len;i++ ){
            if(i%2==0){
                tmp=tmp+"0";
            }else{
                tmp =tmp+""+a;
            }
        }
        int t = Integer.valueOf(tmp);
        return "";
    }
}
