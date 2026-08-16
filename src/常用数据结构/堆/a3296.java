package 常用数据结构.堆;

import java.util.PriorityQueue;

public class a3296 {

    // 计算"将下一个1m高度"分配给哪个工人, 总耗时会最小
    // 分配给工人后, time[i] += x * workerTimes[i], 其中x = 这是该工人工作的第x个1m
    // 总耗时 = max(time[i]), 找出总耗时的最小值

    // 进行mount次分配, 每次计算分配完后的总耗时, 循环结束后就是答案

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                ( a,b) -> {
                    return Long.compare(a[0], b[0]);
                }
        );

        for(int t : workerTimes) {
            pq.offer(new long[]{t, t, t});
            // 分配下一个"1m"给该位置后的总耗时, 下一次操作耗时, workerTimes[i]
        }

        long result = 0;
        while(mountainHeight -- > 0) {
            long[] t = pq.poll();
            result = t[0];
            t[1] = t[1] + t[2];
            t[0] = t[0] + t[1];
            pq.offer(t);
        }

        return result;
    }

}
