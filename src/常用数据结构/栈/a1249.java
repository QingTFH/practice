package 常用数据结构.栈;

public class a1249 {

    // 没有左括号匹配的右括号, 和没有右括号匹配的左括号, 都需要删除

    // 顺序遍历一遍删除前者, 后序遍历一遍删除后者;

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') {
                sb.append(c);
                left++;
            } else if(c == ')') {
                if(left > 0) {
                    sb.append(c);
                    left--;
                }
            } else {
                sb.append(c);
            }
        }

        char[] tmp = sb.toString().toCharArray();
        sb = new StringBuilder();
        int right = 0;
        for (int i = tmp.length - 1; i >= 0; i--) {
            char c = tmp[i];
            if(c == ')') {
                sb.append(c);
                right++;
            } else if(c == '(') {
                if(right > 0) {
                    sb.append(c);
                    right--;
                }
            } else {
                sb.append(c);
            }
        }

        return sb.reverse().toString();
    }

}
