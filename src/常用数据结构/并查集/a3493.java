package 常用数据结构.并查集;

import java.util.Arrays;
import java.util.HashSet;

public class a3493 {

    // 本来还在考虑建集的O(n^2)要如何优化, 看完题解发现题解也是O(n^2), 那我就放心了

    // 耗时过长, 询问后认为是intersect导致的, 每次都要新建两个set而且重复初始化, 应当预处理然后用set进行操作

    public int numberOfComponents(int[][] properties, int k) {
        // 1. 暴力O(n^2)遍历集合, 建立并查集
        UnionFind union = new UnionFind(properties.length);
        for (int i = 0; i < properties.length; i++) {
            for (int j = i + 1; j < properties.length; j++) {
                if (intersect(properties[i], properties[j]) >= k) {
                    union.merge(i, j);
                }
            }
        }

        // 2. 返回并查集的cc
        return union.cc;
    }

    private int intersect(int[] a, int[] b) {
        HashSet<Integer> as = new HashSet<>();
        for (int n : a) {
            as.add(n);
        }
        HashSet<Integer> bs = new HashSet<>();

        int ans = 0;
        for (int n : b) {
            if(as.contains(n) && !bs.contains(n)) { // 有没有方便的方法表示?
                ans++;
                bs.add(n);
            }
        }
        return ans;
    }

    class UnionFind {
        private final int[] fa; // 代表元
        private final int[] size;
        private int cc; // 连通集数量

        UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            cc = n;
            size = new int[n];
            Arrays.fill(size, 1);
        }

        public int find(int x) {
            if (fa[x] != x) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        public boolean merge(int from, int to) {
            int x = find(from);
            int y = find(to);
            if (x == y) {
                return false;
            }
            if(size[x] > size[y]) { // 保证x是小树
                int tmp = x;
                x = y;
                y = tmp; // 交换二者
            }
            fa[x] = y; // 将x挂到y上
            size[y] += size[x];
            cc--;
            return true;
        }
    }

}
