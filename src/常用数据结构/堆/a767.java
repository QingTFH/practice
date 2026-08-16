package 常用数据结构.堆;

import java.util.PriorityQueue;

public class a767 {

    // 类似984的贪心思想, 需要尽可能消耗数量最多的字符;
    // 也就是说, 尽可能让剩余数量最多的字符(首选项)尽快填充, 不合法时取剩余数量第二多(备选项), 直到不存在合法情况, 返回空

    // 注意Integer自带toString方法, 不能直接sb.append, 要转换类型;

    // 方法偏慢
    // 备选项其实不需要是第二多的字符, 任意还能写入的字符皆可
    // 可以先填索引为偶数(0,2,4...)的位置,再填奇数, 只要数量最多的字符 <= (s.length + 1) / 2 (向下取整) (也就是占比不超过一半)
    // 就一定可以间隔摆放;

    public String reorganizeString(String s) {
        // 1. 提取各个字符的数量
        int[] c = new int[26];
        for (char ch : s.toCharArray()) {
            c[ch - 'a'] ++;
        }

        // 2. 建堆
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                (i, j) -> {
                    return - Integer.compare(i[0], j[0]); // 降序排列
                }
        );
        for (int i = 0; i < 26; i++) {
            if(c[i] > 0) pq.add(new Integer[]{c[i], 'a' + i}); // {剩余数量, 字符}
        }

        // 3. 尝试构建字符串
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            if(sb.length() == 0 || pq.peek()[1] != sb.charAt(sb.length() - 1)) { // 放入首选项
                Integer[] t = pq.poll();
                t[0] --;
                sb.append(Character.toChars(t[1]));
                if(t[0] > 0) pq.add(t);
            } else { // 需要放入备选项
                if(pq.size() == 1) { // 不存在备选项
                    return "";
                }
                Integer[] temp = pq.poll();
                Integer[] t = pq.poll();
                t[0] --;
                sb.append(Character.toChars(t[1]));
                if(t[0] > 0) pq.add(t);
                pq.add(temp);
            }
        }

        return sb.toString();
    }

}
