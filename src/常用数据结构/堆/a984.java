package 常用数据结构.堆;

public class a984 {

    // 在堆的题单下，但描述为“不需要堆，引入贪心思想”
    // 要求正好包含a个'a'和b个'b', 但是连续的字母长度不能超过3, 保证一定存在s
    // 那只要每次操作的时候放入尽量多的"剩余较多"的字母即可, 使用计数器计入连续字符?

    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char[] c = new char[]{'a', 'b'};
        int[] t = new int[]{a, b};
        while(t[0] > 0 || t[1] > 0) {
            // 需要考虑当前连续字符数 和 剩余需求字符数;
            // 如果当前连续字符数未到达上限2, 则可以无视限制放入
            // 否则, 强制更改放入的字符
            if(cnt == 2) {
                int pos = 1 - (sb.charAt(sb.length() - 1) - 'a');
                sb.append(c[pos]);
                t[pos]--;
                cnt = 1;
            } else {
                int pos = t[0] > t[1] ? 0 : 1;
                sb.append(c[pos]);
                t[pos] --;
                cnt = (sb.length() == 1 || sb.charAt(sb.length() - 2) != c[pos]) ? 1 : 2; // 首个字符 或者 和倒二个字符不同
            }
        }

        return sb.toString();
    }

}
