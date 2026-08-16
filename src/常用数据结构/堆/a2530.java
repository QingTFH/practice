package 常用数据结构.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class a2530 {

    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : nums) {
            pq.offer(i);
        }

        long result = 0;
        while(k-- > 0) {
            int t = pq.poll();
            pq.offer((int) Math.ceil((double) t / 3));
            result += t;
        }

        return result;
    }

}
