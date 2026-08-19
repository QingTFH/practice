package 常用数据结构.并查集;

import java.util.Arrays;
import java.util.Map;

public class a684 {

    // 删去连通图中会导致成环的边
    // 删去环的任意一边都可以保持连通, 由于连通时已经等价了, 所以在并查集中等价于"删去第一个导致merge失败的边"

    public int[] findRedundantConnection(int[][] edges) {
        int n = 0; // 节点个数
        for (int[] nums : edges) {
            n = Math.max(n, Math.max(nums[0], nums[1]));
        }

        UnionFind union = new UnionFind(n);
        for (int[] nums : edges) {
            if(!union.merge(nums[0]-1, nums[1]-1)) return nums; // 编号为x的索引为x-1
        }

        return new int[]{0,0};
    }

    class UnionFind {
        private final int[] fa; // 代表元

        UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            if (fa[x] != x) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        public boolean isSame(int x, int y) { // 判断 x 和 y 是否在同一个集合
            return find(x) == find(y);
        }

        public boolean merge(int from, int to) {
            int x = find(from);
            int y = find(to);
            if (x == y) {
                return false;
            }
            fa[x] = y;
            return true;
        }
    }

}
