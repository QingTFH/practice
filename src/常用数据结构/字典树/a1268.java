package 常用数据结构.字典树;

import java.util.ArrayList;
import java.util.List;

public class a1268 {

    // 需要注意list的sublist操作返回的是一个子数组窗口，而不是直接截断

    // 耗时过长, 询问后理解只要是"先建立, 再dfs搜索"的, 都要尝试在建树的时候预计算
    // 对于本题：每个节点可以在插入时存放“当前节点的子树中, 字典序最小的三个路径”

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // 1. 建树
        TrieNode root = initTrie(products);

        // 2. 对于每一次搜索, 找到以"prefix"为前缀的最左侧的三个word -> 找到prefix的节点, dfs至少三个子树
        List<List<String>> ans = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            prefix.append(c);
            TrieNode node = findNode(prefix.toString(), root);
            List<String> list = new ArrayList<>();
            if(node != null) dfs(list, "", node, prefix.toString());
            if(list.size() > 3) list.subList(3, list.size()).clear();
            ans.add(list);
        }

        return ans;
    }

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode initTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String s : words) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        return root;
    }

    private void dfs(List<String> list, String path, TrieNode node, String prefix) {
        // 每一层需要返回: 如果当前节点isEnd, 就把path加入List中
        if (node.isEnd) {
            list.add(prefix + path);
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                dfs(list, path + (char)('a' + i), node.children[i], prefix);
            }
        }
    }

    private TrieNode findNode(String word, TrieNode root) {
        // 找到树中word对应的节点
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return null;
            node = node.children[c - 'a'];
        }
        return node;
    }

}
