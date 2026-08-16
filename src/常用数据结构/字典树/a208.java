package 常用数据结构.字典树;

public class a208 {

    // 字典树的模板类

    // 暂时不知道字典树有什么具体作用

    class Trie {

        private TrieNode root = new TrieNode();

        public Trie() {
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i);
                TrieNode child = node.children[c - 'a'] == null ? new TrieNode() : node.children[c - 'a'];
                node.children[c - 'a'] = child;
                node = child;
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            return find(word) == 2;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) > 0;
        }

        private int find(String word) {
            // 返回值: 找到了, 是完整word(2) / 只是前缀(1) || 没找到(0)
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i);
                TrieNode child = node.children[c - 'a'];
                if(child == null) {
                    return 0;
                }
                node = child;
            }

            return node.isEnd ? 2 : 1;
        }

        class TrieNode {
            boolean isEnd = false;
            TrieNode[] children = new TrieNode[26];

            TrieNode() { // 默认不是end
            }
        }

    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */


}
