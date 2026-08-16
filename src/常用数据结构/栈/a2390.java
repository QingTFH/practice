package 常用数据结构.栈;

public class a2390 {

    public String removeStars(String s) {
        char[] chars = s.toCharArray();
        char[] stack = new char[s.length()];
        int pos = -1; // 栈顶的位置

        for(char c : chars) {
            if(c != '*') { // 入栈
                stack[++pos] = c;
            } else { // 出栈
                stack[pos--] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= pos; i++) {
            sb.append(stack[i]);
        }

        return sb.toString();
    }

}
