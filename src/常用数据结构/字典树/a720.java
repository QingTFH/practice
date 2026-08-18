package 常用数据结构.字典树;

public class a720 {

    // 构造字典树, dfs搜索一条最长的, 最靠左侧的, 除了root每一个节点都是end的路径

    public String longestWord(String[] words) {
        TrieNode root = initTrie(words);
        root.isEnd = true;
        return dfs("", root);
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

    private String dfs(String path, TrieNode node) {
        // 每一段需要知道: 自己的路径字符串, 自己的节点
        // 每一段需要传回: 自己/自己孩子的结果, 也就是这一条分支的最长路径

        if(!node.isEnd) { // 自己这个节点不合法, 那么后续都不会合法, 截断自身的字符后返回
            return path.substring(0, path.length() - 1); // 左闭右开
        }

        String ans = null;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                String tmp = dfs(path + (char)('a' + i), node.children[i]);
                if (ans == null || tmp.length() > ans.length()) ans = tmp; // 后遍历的字典序一定更大, 直接大于即可
            }
        }

        return ans == null ? path : ans;
    }


}
