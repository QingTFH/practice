package 常用数据结构.队列;

import java.util.ArrayDeque;
import java.util.Queue;

public class a933 {

    class RecentCounter {

        Queue<Integer> queue = new ArrayDeque<>();

        public RecentCounter() {
        }

        public int ping(int t) {
            // 在时间t发生了一个请求; 返回[t-3000, t]发生的请求数
            while(!queue.isEmpty() && queue.peek() < t-3000) {
                queue.poll();
            }
            queue.offer(t);
            return queue.size();
        }
    }

}
