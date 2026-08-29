package 链表_二叉树_回溯.回溯;

import java.util.ArrayList;
import java.util.List;

public class a17 {


    final String[] st = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();
    String s;
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        s = digits;
        dfs(0);
        return result;
    }

    private void dfs(int index) {
        if (index >= s.length())
            return;

        for (char c : st[s.charAt(index) - '2'].toCharArray()) {    // 本来还想着3*sc-'2' + i的, 结果有两个能映射4字母的数字
            sb.append(c);
            if (index == s.length() - 1) {
                result.add(sb.toString());
            } else {
                dfs(index + 1);
            }
            sb.deleteCharAt(index);
        }
    }

}
