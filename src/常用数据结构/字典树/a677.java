package 常用数据结构.字典树;

import java.util.TimerTask;

public class a677 {

    class MapSum {

        TrieNode root = new TrieNode();

        public MapSum() {}

        // 如果键 key 已经存在，那么原来的键值对 key-value 将被替代成新的键值对
        public void insert(String key, int val) {
            insertTrie(key, val, root);
        }

        // 返回所有以该前缀 prefix 开头的键 key 的值的总和
        public int sum(String prefix) {
            // 以prefix为前缀 -> prefix的子树
            TrieNode node = findNode(prefix, root);
            return node == null ? 0 : sumTrie(node);
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            int score = 0;
        }

        private void insertTrie(String key, int val, TrieNode root) {
            TrieNode node = root;
            for (char c : key.toCharArray()) {
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.score = val;
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

        private int sumTrie(TrieNode node) {
            // dfs统计root为根节点的树的分数
            // 每一步需要知道: 当前节点
            // 每一步需要返回: 分数
            int result = node.score; // 本层

            for(int i = 0; i < 26; i++) { // 下一层
                if (node.children[i] != null) {
                    result += sumTrie(node.children[i]);
                }
            }

            return result; // 上一层
        }
    }

}
