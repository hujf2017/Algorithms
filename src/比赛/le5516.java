package 比赛;

import java.util.*;

/**
 * @author Hujf
 * @title: le5516
 * @date 2020/10/3 0003下午 10:43
 * @description: TODO
 */
public class le5516 {

    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Set<String> a = new HashSet<>();
        int count = 0;
        String lastName = "";
        int lastTime = 24 * 60;
        for (int i = 0; i < keyName.length; i++) {
            String s = keyTime[i].substring(0, 2);
            String s2 = keyTime[i].substring(3, 5);
            int time = Integer.valueOf(s) * 60 + Integer.valueOf(s2);
            if (lastName.equals(keyName[i])&& time-lastTime>=0&&time-lastTime<=60) {
                count++;
                if (count == 3) {
                    a.add(lastName);
                }

            }else if (lastName.equals(keyName[i])&&count>=2&& time-lastTime>=0) {
                String sx = keyTime[i - 2].substring(0, 2);
                String sx2 = keyTime[i - 2].substring(3, 5);
                lastTime = Integer.valueOf(sx) * 60 + Integer.valueOf(sx2) + 60;
                if (lastTime >= time) {
                    a.add(lastName);
                }

            } else {
                String sx = keyTime[i].substring(0, 2);
                String sx2 = keyTime[i].substring(3, 5);
                count = 1;
                lastName = keyName[i];
                lastTime = Integer.valueOf(sx) * 60 + Integer.valueOf(sx2);

            }
        }

        List<String> k = new ArrayList(a);
        Collections.sort(k);
        return k;
    }

        
    public static void main(String args[]) {
        String ax[] = {"leslie","leslie","leslie","clare","clare","clare","clare"};
        String b[] = {"23:20","23:50","00:01","18:00","18:51","19:30","19:49"};
        List asda = alertNames(ax, b);
        System.out.println(asda);
    }
}
