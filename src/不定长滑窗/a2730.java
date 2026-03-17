public class a2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        //预处理字符串，相邻重复的位置记为1；滑窗找到最长的只含两个连续1的窗口(寒假时候的思路)

        //思路错误："0011"这个字符串会被预处理为"1111"
        //应该判断
        //  1.入窗口的数字与原先的队列头是否相等，若相等此时相等数+1；
        //  2.出窗口的数字与当前的队列尾是否相等，若相等此时相等数-1
        //  3.直到当前相等数<=1
        int n =s.length();
        int l=0,r=0,maxLen=0,equalNum=0;

        for(;r<n;r++){
            if(r >= 1 && s.charAt(r)==s.charAt(r-1)) { // 判断1
                equalNum += 1;
            }

            while(equalNum > 1) { // 窗口合法化
                l++;
                if(s.charAt(l) == s.charAt(l - 1)) {
                    equalNum -= 1;
                }
            }
            maxLen = Math.max(maxLen,r-l+1);
        }

        return maxLen;
    }
}
