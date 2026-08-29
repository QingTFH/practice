package 链表_二叉树_回溯.回溯;

import java.util.ArrayList;
import java.util.List;

public class a784 {

    // 遇到一个字母时, 它有两个分支: 不变 和 变

    // 修改String可以用char[] c = string.toCharArray 操作c后 String s2 = new String(c)

    StringBuilder sb = new StringBuilder();
    char[] s;
    List<String> result = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        this.s = s.toCharArray();
        dfs(0);
        return result;
    }

    private void dfs(int index) {
        if (index == s.length) {
            result.add(sb.toString());
            return;
        }

        char c = s[index];
        help(c, index); // 无论是不是字母, 都有一个添加自己的操作
        if (Character.isLetter(c)) {
            help((char) (c ^ ' '), index);  // 大小写转换差值为32 <-> c ^ 32 <-> c ^ ' '或者 c ^ 1 << 5
        }

    }

    private void help(char c, int index) {
        sb.append(c);
        dfs(index + 1);
        sb.deleteCharAt(index);
    }

}
