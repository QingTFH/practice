package 常用数据结构.栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class a71 {

    public String simplifyPath(String path) {
        Parser parser = new Parser(path);
        Deque<String> stack = new ArrayDeque<>();
        String s;
        while((s = parser.parse()) != null) {
            if(s.equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else if(!s.equals(".")) {
                stack.push(s);
            }
        }

        Iterator<String> it = stack.descendingIterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append("/");
            sb.append(it.next());
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }

    class Parser {

        int pos = 0;
        String s;

        Parser(String s) {
            this.s = s;
        }

        public String parse() {
            // 从pos开始解析一段路径名; 保证path[pos]一定是'/'
            StringBuilder sb = new StringBuilder();
            if(pos == s.length()) return null;

            // 忽略若干个'/'
            while(pos < s.length() && s.charAt(pos) == '/') {
                pos++;
            }

            if(pos == s.length()) return null;

            // 提取路径名, 直到遇到下一个/
            while(pos < s.length() && s.charAt(pos) != '/') {
                sb.append(s.charAt(pos));
                pos++;
            }

            return sb.toString();
        }

    }



}
