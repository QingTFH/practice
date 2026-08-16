package 常用数据结构.堆;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class a1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder()); // 默认是小顶堆
        Arrays.stream(stones).boxed().forEach(heap::offer);

        while(heap.size() > 1) { // 不止剩下一块石头
            int a = heap.poll();
            int b = heap.poll();
            if(a > b) heap.offer(a - b);
        }

        return heap.isEmpty() ? 0 : heap.poll();
    }

}
