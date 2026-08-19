package 常用数据结构.并查集;


import java.util.Arrays;

public class a3532 {

    // 依旧是连通性查询, 使用预建立并查集 + 查找的方式
    // 预处理阶段, 由于数组是升序 + 需要求i, j的差值, 似乎可以用滑动窗口

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int left = 0, right = 1, diff = 0;
        UnionFind unionFind = new UnionFind(n);
        while (right < nums.length) {
            if (right > 0)
                diff += nums[right] - nums[right - 1]; // 左端点和右端点的差值
            while (diff > maxDiff && left <= right) { // 不合法
                left++;
                diff -= nums[left] - nums[left - 1]; // 左端点右移
            }
            unionFind.merge(left, right);
            right ++;
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = (unionFind.find(queries[i][0]) == unionFind.find(queries[i][1]));
        }

        return result;
    }

    class UnionFind {
        final int[] parent;
        final int[] size;
        int cc;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i; // 初始时, 所有节点都是根节点, 因此它的父亲是它自己
            }

            size = new int[n];
            Arrays.fill(size, 1); // 初始时, 所有集合大小都是1

            cc = n; // 初始时有n个集合
        }

        public boolean merge(int from, int to) { // 把from和to所在的两个集合合并
            int x = find(from);
            int y = find(to);
            if (x == y) {
                return false;
            }

            // 保证x是小树
            if (size[x] > size[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }

            // 把x挂到y上
            size[y] += size[x];
            parent[x] = y;
            cc --;
            return true;
        }

        public int find(int node) { // 找到node的根节点
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // 压缩路径, 递归找到root并更改沿途的路径
            }
            return parent[node];
        }

    }


}
