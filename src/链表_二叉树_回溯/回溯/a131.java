package 链表_二叉树_回溯.回溯;

import java.util.ArrayList;
import java.util.List;

public class a131 {

    // 连续子串组 <-> 对于每个可能的划分位置选择"划分 or not"
    // 不选择 -> 此处不分割 -> sb继续append
    //      复原: remove
    // 选择 -> 此处分割 -> sb直接toString 并 clear
    //      复原: new SB(string)

    List<List<String>> ans = new ArrayList<>();     // 答案
    ArrayList<String> stringList = new ArrayList<>();    // 当前的list
    String s;

    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0, new StringBuilder());
        return ans;
    }

    private void dfs(int index, StringBuilder sb) {
        // 考虑在s[index]后分割, 还是不分割
        if (index == s.length()) {  // 边界情况, 此时

            return;
        }

        sb.append(s.charAt(index));

        // 不分割 -> index = length - 1时必须分割, 不然会产生空串
        if (index < sb.length() - 1)
            dfs(index + 1, sb);

        // 分割
        String st = sb.toString();

        // 要确认是回文串才能add, 否则进入下一个位置再尝试分割;
        //
        if (tryPush(st)) {
            stringList.add(st);
            dfs(index + 1, new StringBuilder());
            stringList.remove(stringList.size() - 1);
        }

        sb.deleteCharAt(sb.length() - 1);
    }

    private boolean tryPush(String st) {
        for (int l = 0, r = st.length() - 1; l < r; l++, r--) {
            if (st.charAt(l) != st.charAt(r)) {
                return false;
            }
        }
        return true;
    }

}
