package 常用数据结构.堆;

import java.util.PriorityQueue;

public class a3264 {

    // 需要多次找到最小值 -> 堆
    // 需要保持原数组顺序不变 -> 重写堆的比较器

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (i, j) -> {
                    if(nums[i] != nums[j]) {
                        return Integer.compare(nums[i], nums[j]);
                    } else {
                        return Integer.compare(i, j);
                    }
                }
        ); // Comparator返回负 -> i的优先级更高 -> i在前(与默认小顶堆相同)

        for(int i = 0; i < nums.length; i++) {
            heap.offer(i);
        }

        while(k > 0) {
            k--;
            int index = heap.poll();
            nums[index] *= multiplier;
            heap.offer(index);
        }

        return nums;
    }

}
