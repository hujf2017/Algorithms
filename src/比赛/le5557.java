package 比赛;

/**
 * @author Hujf
 * @title: le5557
 * @date 2020/11/28 0028下午 10:36
 * @description: TODO
 */
public class le5557 {
    public int maxRepeating(String sequence, String word) {
        String s = sequence.replaceAll(word,"-");
        char[] chars = s.toCharArray();
        int count =0;
        int max=0;
        for(int i=0;i<s.length();i++){
            if(chars[i]=='-'){
                count ++;
            }else{
                if(max<count){
                    max =count;

                }
                count=0;
            }
        }
        return Math.max(count,max);
    }
}
