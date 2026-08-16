package 常用数据结构.栈;

public class a1209 {

    public String removeDuplicates(String s, int k) {
        char[] stackChar = new char[s.length()];
        int[] stackInt = new int[s.length()]; // 将"aaaa" 压缩成 "a, 4"
        int top = -1;

        for(char c : s.toCharArray()) {
            if(top >= 0 && c == stackChar[top]) { // 需要处理
                // 情况1: 删除;
                if(stackInt[top] == k-1) top--;

                // 情况2: 次数+1
                else stackInt[top]++;
            } else { // 直接入栈
                stackChar[++top] = c;
                stackInt[top] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= top; i++) {
            for (int j = 0; j < stackInt[i]; j++) {
                sb.append(stackChar[i]);
            }
        }
        return sb.toString();
    }

}
