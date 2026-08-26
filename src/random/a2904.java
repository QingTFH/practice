package random;

import java.util.Objects;

public class a2904 {

    // 滑窗, 找到合法的子字符串并比较len, 再比较字典序
    // 考虑中间情况: 已有一个合法窗口"1.....1", 如何找到下一个合法窗口
    //      1. 剥离左端的1, 使其不合法
    //      2. 扩充右端, 直至恰好合法
    //      3. 剥离左端的0, 使其最简
    // 考虑初始情况: 如何构造一个合法窗口
    //      1. 扩充右端, 直至恰好合法
    //      2. 剥离左端的0, 使其最简

    public String shortestBeautifulSubstring(String s, int k) {
        int cnt = 0, l = 0, r = 0; // 左闭右开
        String ans = "";
        while (r < s.length()) {
            // 1. 收缩左边界
            if (l < r && s.charAt(l) == '1') {
                cnt--;
                l++;
            }

            // 2. 拓展右边界, 保证合法
            while (cnt < k && r < s.length()) {
                if (s.charAt(r) == '1')
                    cnt++;
                r++;
            }

            while (l < r && s.charAt(l) == '0') // 过滤掉无用的0, 保证下一个字符串是最短且合法的
                l++;

            // 此时的窗口[l, r)为下一个合法的美丽子字符串
            if (cnt == k)
                ans = filter(ans, s.substring(l, r));
        }

        return ans;
    }

    private String filter(String a, String b) {
        // 找到合法的, len小的, 字典序小的子字符串
        if (a.isEmpty())
            return b;
        if (b.isEmpty())
            return a;

        int la = a.length(), lb = b.length();
        if (la != lb)
            return la > lb ? b : a;

        return a.compareTo(b) < 0 ? a : b;
    }

}
