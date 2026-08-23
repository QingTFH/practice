package random;

public class a1927 {

    // 博弈论的题不能使用模拟和贪心, 一定需要基于先后手的优劣势和数学计算分析胜负性

    // 扫描一遍, 处理成一个数据结构, 记录"前半和""前半问号数"; "后半和""后半问号数"


    public boolean sumGame(String num) {
        int preSum = 0, preQ = 0, half = num.length() / 2;
        for (int i = 0; i < half; i++) {
            int c = num.charAt(i);
            if (c == '?') preQ++;
            else preSum += c - '0';
        }

        int sufSum = 0, sufQ = 0, tail = num.length();
        for (int i = half; i < tail; i++) {
            int c = num.charAt(i);
            if (c == '?') sufQ++;
            else sufSum += c - '0';
        }

        if ((preQ + sufQ) % 2 != 0)
            return true;


        return (preSum - sufSum) + 9 * (preQ - sufQ) / 2 != 0;
    }


}
