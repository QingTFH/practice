package 常用数据结构.栈;

public class a1047 {

    public String removeDuplicates(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for(char c : s.toCharArray()) {
            if(top >= 0 && c == stack[top]) {
                top--;
            } else {
                stack[++top] = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            sb.append(stack[i]);
        }
        return sb.toString();
    }

}
