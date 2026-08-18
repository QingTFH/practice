package 常用数据结构.字典树;

import java.util.List;

public class a648 {

    // 直接使用字典树即可, 对于sentence中的每一个单词, 如果找不到词根则维持, 否则替换为最早遇到的root - end

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        // 1. 造字典树
        for (String s : dictionary) {
            TrieNode node = root;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        // 2. 分割sentence为List<> words, 对每个word尝试进行替换
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++) {
            // 尝试走通words
            String pre = startWith(root, words[i]);
            if (pre != null) {
                words[i] = pre;
            }
        }

        // 3. 将words还原为sentence
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++) {
            if(i != 0) sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }

    private String startWith(TrieNode root, String s) {
        // 判断字典树中有没有s的前缀, 如果有将其返回, 否则返回null
        TrieNode node = root;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(node.isEnd) return sb.toString(); // 总结前面的路

            if(node.children[c - 'a'] == null) return null;
            sb.append(c);
            node = node.children[c - 'a'];
        }

        if(node.isEnd) return sb.toString();
        return null;
    }

    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }

}
