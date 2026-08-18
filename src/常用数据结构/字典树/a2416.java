package 常用数据结构.字典树;

public class a2416 {

    // 直接想法: 建树 -> 计算每个word的分数(HashMap) -> 计算answer

    // 查询题解后理解: 对于每个节点而言, 它是它孩子的前缀 -> 插入word时每经过一次节点node, 它作为前缀的个数就会+1 -> 分数+1
    // ans[i] = 累加经过的每个节点的score

    public int[] sumPrefixScores(String[] words) {
        TrieNode root = initTrie(words);

        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            TrieNode node = root;
            int score = 0;

            for (char c : s.toCharArray()) {
                node = node.children[c - 'a'];
                score += node.score;
            }

            ans[i] = score;
        }
        return ans;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int score = 0;
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
                node.score ++;
            }
        }

        return root;
    }

}
