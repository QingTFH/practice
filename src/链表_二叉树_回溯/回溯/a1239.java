package 链表_二叉树_回溯.回溯;

import java.util.ArrayList;
import java.util.List;

public class a1239 {

    // 将arr[i*]组合得到字符串s, 其中arr[i*]间没有相同的字符; 返回s可能的最长长度
    // 选 or not的回溯遍历, 关键在于如何快速知道arr[i]与arr[j]没有相同的字符

    // 看了题解: 同样可以使用预处理的方法, 将string转化成二进制数, 取与的结果>=1则有重复

    List<String> arr;
    boolean[] mask = new boolean[26];

    public int maxLength(List<String> arr) {
        this.arr = arr;
        return dfs(0);
    }

    private int dfs(int index) {
        if (index == arr.size())
            return size();

        int r = dfs(index + 1); // 不选index位置的string

        boolean[] temp = mask.clone();
        boolean canPick = true;

        // 尝试布置现场 -> 如果不合法, 本子树不可达, 直接回溯现场
        for (char c : arr.get(index).toCharArray()) {
            if (mask[c - 'a']) {
                canPick = false;
                break;
            }
            else
                mask[c - 'a'] = true;
        }

        if (canPick)
            r = Math.max(r, dfs(index + 1));

        // 回溯现场
        mask = temp;


        return r;
    }

    private int size() {
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (mask[i])
                cnt++;
        }
        return cnt;
    }

}

class Solution2 {
    // 使用二进制数的第二解
    // 优雅, 快速; 以后要多尝试用二进制数来记录

    List<Integer> mask = new ArrayList<>();

    public int maxLength(List<String> arr) {
        // 预处理
        for (String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                int t = 1 << (c - 'a');
                if ((mask & t) != 0) {  // 说明s中有重复数字, 直接不可用
                    mask = -1;
                    break;
                } else {
                    mask |= t;
                }
            }
            if (mask > 0)
                this.mask.add(mask);
        }

        return dfs(0, 0);
    }

    private int dfs(int index, int pre) {
        if (index == mask.size())
            return Integer.bitCount(pre);

        // 不选第index个字符串
        int r = dfs(index + 1, pre);

        // 选第index个字符串
        if ((pre & mask.get(index)) == 0) { // 可以选
            pre |= mask.get(index);
            r = Math.max(dfs(index + 1, pre), r);
        }

        return r;
    }

}
