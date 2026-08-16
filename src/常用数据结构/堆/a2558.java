package 常用数据结构.堆;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class a2558 {

    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(gifts).forEach(pq::offer);

        while(k-- > 0) {
            int t = pq.poll();
            pq.offer((int) Math.sqrt(t));
        }

        long result = 0;
        while(!pq.isEmpty()) {
            result += pq.poll();
        }

        return result;
    }

}
