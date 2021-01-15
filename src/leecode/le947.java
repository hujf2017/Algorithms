package leecode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hujf
 * @title: le947
 * @date 2021/1/15 0015上午 8:26
 * @description: TODO
 */
public class le947 {
    class UnionFind{
        int [] parent;
        int res;
        UnionFind(int n){
            parent = new int[n];
            for(int i=0;i<parent.length;i++){
                parent[i] = i;
            }
            res = n;
        }

        public boolean union(int x, Integer y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX==rootY){
                return false;
            }
            parent[rootX] = rootY;
            //合并成功，则剩余连通区域的数量-1
            res--;
            return true;
        }
        public int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public int getRes(){
            return res;
        }
    }
    public int removeStone(int [][]stones){
        Map<Integer,Integer> row = new HashMap<>();
        //储存点的行坐标，V是点的编号
        Map<Integer,Integer> col = new HashMap<>();

        int n = stones.length;
        //初始化并查集
        UnionFind unionFind = new UnionFind(n);
        for(int i=0;i<n;i++){
            //找到当前点
            int [] cur =stones[i];
            int tmp = i;
            //int rootX = row.computeIfAbsent(cur[0],e->tmp);
            //int rootY = col.computeIfAbsent(cur[1],e->tmp);
            row.putIfAbsent(cur[0],i);
            col.putIfAbsent(cur[1],i);
            unionFind.union(i,row.get(cur[0]));
            unionFind.union(i,col.get(cur[1]));

        }
        return n - unionFind.getRes();
    }
    @Test
    public void t(){
        int a[][] = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        removeStone(a);
    }
}
