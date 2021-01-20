package leecode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Hujf
 * @title: le1584
 * @date 2021/1/19 0019上午 10:02
 * @description: \text{Kruskal}Kruskal 算法
 */
public class le1584 {

    public int minCostConnectPoints(int[][] points) {
        //得到所有点数量
        int n = points.length;
        //初始化并查集
        DisJoinSetUnion dsu  = new DisJoinSetUnion(n);

        List<Edge> edges = new ArrayList<Edge>();
        //双循环得到所有的边和点关系
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(dist(points, i, j), i, j));
            }
        }

//        //对所有边进行排序 从小到大
//       Collections.sort(edges,new Comparator<Edge>(){
//           @Override
//           public int compare(Edge o1, Edge o2) {
//               return o1.len-o2.len;
//           }
//       });
        edges =edges.stream().sorted(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.len-o2.len;
            }
        }).collect(Collectors.toList());

        int ret =0,num=1;
        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (dsu.unionSet(x, y)) {
                ret += len;
                num++;
                if (num == n) {
                    break;
                }
            }
        }
        return ret;
    }

    private int dist(int[][] points, int x, int y) {
        return Math.abs(points[x][0] - points[y][0]) + Math.abs(points[x][1] - points[y][1]);
    }
}
class DisJoinSetUnion {
    int[] f;
    int[] rank;
    int n;
    public DisJoinSetUnion(int n) {
        this.n = n;
        this.rank = new int[n];
        Arrays.fill(this.rank, 1);
        this.f = new int[n];
        for (int i = 0; i < n; i++) {
            this.f[i] = i;
        }

    }

    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    public boolean unionSet(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return false;
        }
        if (rank[fx] < rank[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
        return true;
    }
}

class Edge {
    int len, x, y;

    public Edge(int len, int x, int y) {
        this.len = len;
        this.x = x;
        this.y = y;
    }
}

