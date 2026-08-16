package 常用数据结构.堆;

import java.util.Comparator;
import java.util.PriorityQueue;

public class a2233 {

    public int maximumProduct(int[] nums, int k) {
        final long MOD = 1_000_000_007;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.offer(num);
        }

        while(k-- > 0) {
            pq.offer(pq.poll() + 1);
        }

        long result = 1;
        while(!pq.isEmpty()) {
            result = ((result % MOD) * (pq.poll() % MOD)) % MOD;
        }

        return (int)result;
    }

}
