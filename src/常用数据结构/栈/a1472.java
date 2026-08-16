package 常用数据结构.栈;

public class a1472 {

    class BrowserHistory {

        String now;
        String[] stack = new String[5008];
        int top = -1; // 栈顶的位置
        int pos = 0; // 当前访问的位置; pos <= top

        public BrowserHistory(String homepage) {
            now = homepage;
            push(now);
        }

        public void visit(String url) {
            // 1. 清空"允许前进"的记录
            top = pos; // 直接截断

            // 2. 跳转到新页面
            now = url;
            push(now);
            pos++;
        }

        public String back(int steps) {
            int diff = pos;
            int s = Math.min(steps, diff);

            pos -= s;
            return stack[pos];
        }

        public String forward(int steps) {
            int diff = top - pos;
            int s = Math.min(steps, diff);

            pos += s;
            return stack[pos];
        }

        private void push(String s) {
            stack[++top] = s;
        }
    }

    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */

}
