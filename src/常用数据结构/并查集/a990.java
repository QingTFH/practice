package 常用数据结构.并查集;

import java.util.Arrays;

public class a990 {

    // 出现矛盾时返回false, 否则返回true

    public boolean equationsPossible(String[] equations) {
        // 1. 构造并查集
        UnionFind find = new UnionFind(26); // 小写字母, 压缩到0~25
        for (String s : equations) {
            if (s.charAt(1) == '=') { // == 和 != 只要判断前一个字符即可
                find.merge(s.charAt(0) - 'a', s.charAt(3) - 'a');
            }
        }

        // 2. 遍历不等式, 寻找矛盾
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                if(find.isSame(s.charAt(0) - 'a', s.charAt(3) - 'a'))
                    return false;
            }
        }

        return true;
    }

    class UnionFind {
        private final int[] fa; // 代表元
        private final int[] size; // 集合大小
        public int cc; // 连通块个数

        UnionFind(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
            cc = n;
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
            size[y] += size[x];
            cc--;
            return true;
        }
    }

}
