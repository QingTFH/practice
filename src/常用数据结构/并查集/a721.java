package 常用数据结构.并查集;

import 单调栈._banzi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class a721 {

    // 比较需要模拟的并查集
    // 对于每一个邮箱, 他初始对应一个账号(父节点); 对于一个账号, 它可能和其他账号属于同一个用户(合并);
    // 发现有两个相同的邮箱挂在不同的账号下, 此时要合并两个账号
    // 对于每一个账号, 可以以初始索引值作为并查集索引, 但我们要遍历的是每个账号(尤其是账号相同)的情况, 所以可能需要用到hashmap?

    // 写的我头昏脑胀的, 感觉思路很不明确, 走一步看一步的, 因此复盘一下思路
    // 我们需要统计邮箱的归属, 以确定账户的归属; 邮箱的上级是账号, 当集合中的一个邮箱被判断为应该合并时, 两个账号也会案发生合并
    // 如何判断邮箱应该合并? 之前出现过这个邮箱;
    // 如何合并账号, 记录name? <-> 如何设计并查集? -> 每个账号在accounts中都存在一个索引, 直接使用索引表示每个账号即可
    // 当合并完账号后, 我们需要表示("用户" -> "邮箱"集), 所以先把所有邮箱都扔到对应的账户的根节点的列表上, 最后再获得name添加进去即可

    // 没有很复杂的算法技巧, 但是模拟、设计和实现上比较困难, 看来这方面也是我薄弱的点

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind(accounts.size());
        HashMap<String, Integer> map = new HashMap<>(); // 邮箱 -> 账户索引
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String s = accounts.get(i).get(j);
                if (map.containsKey(s))
                    unionFind.merge(map.get(s), i);
                else
                    map.put(s, i);
            }
        }

        // 根据并查集的合并结果, 建立List
        Map<Integer, List<String>> indexToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int index = unionFind.find(entry.getValue());
            List<String> list = indexToEmails.getOrDefault(index, new ArrayList<>());
            list.add(entry.getKey());
            indexToEmails.put(index, list);
        }

        // 根据index和list, 建立result
        List<List<String>> result = new ArrayList<>();
        for (int i : indexToEmails.keySet()) {
            String name = accounts.get(i).get(0);
            List<String> list = indexToEmails.get(i);
            list.sort(Comparator.naturalOrder());
            list.add(0, name);
            result.add(list);
        }

        return result;
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

        public int getSize(int x) { // 返回 x 所在集合的大小
            return size[find(x)]; // 集合大小保存在代表元上
        }
    }
}
