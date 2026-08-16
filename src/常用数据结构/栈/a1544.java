package 常用数据结构.栈;

public class a1544 {

    public String makeGood(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for(char c : s.toCharArray()) {
            if(top >= 0 && shouldDelete(c, stack[top])) {
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

    private boolean shouldDelete(char a, char b) {
        return ((Character.isUpperCase(a)) && (a - 'A' == b - 'a'))
                || ((Character.isLowerCase(a)) && (a - 'a' == b - 'A'));
    }

}
