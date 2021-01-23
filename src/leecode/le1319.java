package leecode;

/**
 * @author Hujf
 * @title: le1319
 * @date 2021/1/23 0023上午 8:58
 * @description: TODO
 */
public class le1319 {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        int count=0;
       //已经是一根绳上的蚂蚱 再连接的话就把这根线拿下来  count ++
        //初始化并查集
        UnionFind unionFind = new UnionFind(n);
        for(int []k :connections ){
            //把两个点连接起来  已经连接返回false
            unionFind.union(k[0],k[1]);
        }
        return unionFind.n-1;
    }

    private class UnionFind {
        int []parent;
        int n;
        public UnionFind(int n) {
            this.parent= new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
            this.n = n;
        }

        public boolean union(int x, int y) {
            //2 ,3
            int rootx = find(x);// 5-5  3-5
            int rooty = find(y);//7-7 2-7
            if(rootx==rooty){
                return false;
            }
            parent[rootx] = rooty;//5-7
            n--;
            return true;
        }

        private int find(int x) {
            if(parent[x]!=x){
                parent[x]=find(parent[x]);
            }
            return parent[x];
        }
    }
}
