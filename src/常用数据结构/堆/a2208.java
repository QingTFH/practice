package 常用数据结构.堆;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class a2208 {

    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for(int num : nums) {
            sum += num;
            pq.offer((double) num);
        }
        double upgradeSum = sum;
        int result = 0;
        while(upgradeSum > (sum / 2)) {
            double num = pq.poll() / 2;
            pq.offer(num);
            upgradeSum -= num;
            result ++;
        }
        return result;
    }

}
