package 常用数据结构.并查集;

import java.util.Arrays;

public class a3551 {

    // 假设原数组中各个元素下标i, 排序后对应的是j, 则需要将各个i 移动到正确的j上
    // 初步想法是一次交换可以满足两个, 但是细想发现这需要它们的i和j互相对应, 也就是i1 = j2, i2 = j1;
    // 延续这个思路可以发现, 连接每个i 和 j, 会成环, 也就是“置换环”, 对于每个环, size = n, 它需要的交换次数为n-1
    // 也就是说，统计一共右多少个这样的环及各个环的size ->

    public int minSwaps(int[] nums) {
        // 1. 计算数位和, 排序, 得到i和j, 如何存储? 二维数组, datas[j] = {数位和, 原数字, i}, 排序需要用到前2者
        int[][] datas = new int[nums.length][3];
        for (int i = 0; i < nums.length; i++) {
            datas[i][0] = getNums(nums[i]);
            datas[i][1] = nums[i];
            datas[i][2] = i;
        }
        Arrays.sort(datas,
                (i, j) -> (
                        i[0] == j[0] ? Integer.compare(i[1], j[1]) : Integer.compare(i[0], j[0])
                )
        );

        // 2. 连接i和j, 建立并查集
        UnionFind unionFind = new UnionFind(nums.length);
        for (int j = 0; j < nums.length; j++) {
            int i = datas[j][2];
            unionFind.merge(i, j);
        }

        // 3. 将各个集合的size-1相加, 问题在于如何轻松遍历?
        // 正难则反, 每个集合的size 加起来 = n, 那么集合的size-1相加 = n-cc
        return nums.length - unionFind.cc;
    }

    private int getNums(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n /= 10;
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
