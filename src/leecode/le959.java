package leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hujf
 * @title: le959
 * @date 2021/1/25 0025上午 9:00
 * @description: TODO
 */
public class le959 {
    public int regionsBySlashes(String[] grid) {

        int n=grid.length;

        UnionFind u = new UnionFind(n*n*4);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                //
                int idx = i*n+j;
                if(i<n-1){
                    int bottom = idx + n;
                    u.merge(idx * 4 + 2, bottom * 4);
                }
                if(j<n-1){
                    int right = idx + 1;
                    u.merge(idx * 4 + 1, right * 4+3);
                }

                if (grid[i].charAt(j) == '/') {
                    u.merge(idx * 4, idx * 4 + 3);
                    u.merge(idx * 4 + 1, idx * 4 + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    u.merge( idx * 4, idx * 4 + 1);
                    u.merge( idx * 4 + 2, idx * 4 + 3);
                } else {
                    u.merge( idx * 4, idx * 4 + 1);
                    u.merge( idx * 4 + 1, idx * 4 + 2);
                    u.merge( idx * 4 + 2, idx * 4 + 3);
                }


            }
        }
        Set<Integer> fathers = new HashSet<Integer>();
        for (int i = 0; i < n * n * 4; i++) {
            int fa = u.find( i);
            fathers.add(fa);
        }
        return fathers.size();

    }

    private class UnionFind {
        int []a ;
        int res =0;
        public UnionFind(int n){
            this.a = new int[n];
            this.res = n;
            for(int i=0;i<n;i++){
                a[i] = i;
            }
        }

        public void merge(int x, int y) {
            int fx=find(x);
            int fy=find(y);
            a[fx] = fy;
        }

        private int find(int y) {
            if(a[y]!=y){
                a[y] = find(a[y]);
            }
            return a[y];
        }
    }
}
