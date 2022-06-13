package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author hujf
 * @Date 2022/6/9 10:54
 * @Description 计算得到所有的仇选项
 */
public class le497 {
    List<fangkuang> a = new ArrayList<>();
    public le497(int[][] rects) {
        for(int [] r:rects){
            int henstart = r[0];
            int henend = r[2];
            int shustart = r[1];
            int shuend = r[3];
            a.add(new fangkuang(henstart,henend-henstart,shustart,shuend-shustart));
        }
    }

    public int[] pick() {
        int random = (int) (Math.random()*a.size());
        fangkuang fangkuang = a.get(random);
        int []num = new int[2];
        num[0]= fangkuang.henstart+(int)(Math.random()*(fangkuang.henlen+1));
        num[1] =  fangkuang.shustart+(int)(Math.random()*(fangkuang.shulen+1));
        return num;
    }


    public class fangkuang {
        int henstart;
        int henlen;
        int shustart;
        int shulen;

        public fangkuang(int henstart, int henlen, int shustart, int shulen) {
            this.henstart = henstart;
            this.henlen = henlen;
            this.shustart = shustart;
            this.shulen = shulen;
        }
    }
}
