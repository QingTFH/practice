package 常用数据结构.栈;

public class a1963 {

    // 括号个数确定, 只要统计没有匹配的括号数量即可(只统计一边);
    // 换言之, 可以统计匹配的括号对数, 总对数减去后就是没有匹配的对数;
    // 一次交换可以实现两组成功匹配, 所以需要再除以2并向上取整

    public int minSwaps(String s) {
        int left = 0;
        int matchCnt = 0;
        for (char c : s.toCharArray()) {
            if(c == '[') left++;
            else if(c == ']' && left > 0) {
                left --;
                matchCnt ++;
            }
        }

        return (int) Math.ceil((double)(s.length() / 2 - matchCnt) / 2);
    }

}
