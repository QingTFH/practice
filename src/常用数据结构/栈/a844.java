package 常用数据结构.栈;

public class a844 {

    // 虽然是栈的题单, 但是使用双指针
    // 一个字符会被后面可能存在的“#”给删除, 所以我们可以从后往前遍历并找到确认保留的字符
    // 两个字符串间, "确认保留的字符"逐个比较, 直到不同或是结束

    public boolean backspaceCompare(String s, String t) {
        int pos1 = s.length(), pos2 = t.length();
        while (pos1 >= 0 || pos2 >= 0) {
            // 寻找上一个可以确定字符的索引
            pos1 = getLastChar(pos1, s);
            pos2 = getLastChar(pos2, t);
            System.out.println(pos1 + " " + pos2);

            // 情况: 存在-1 不存在-1
            if(pos1 == -1 || pos2 == -1) {
                if(pos1 == pos2) return true;
                else return false;
            } else if(s.charAt(pos1) != t.charAt(pos2)) {
                return false;
            }
        }

        return true;
    }

    public int getLastChar(int pos, String s) {
        // 寻找"上一个"可以确定字符的索引; 如果不存在, 返回-1
        if(pos <= 0)
            return -1;

        int skip = 0;
        for(;;) {
            pos--;
            if (pos < 0) break;

            skip = (s.charAt(pos) == '#' ? skip + 1 : skip - 1);
            if (skip < 0) break;
        }

        return pos;
    }


}
