package 常用数据结构.堆;

import java.util.HashSet;
import java.util.PriorityQueue;

public class a2336 {

    // 维护一个[1 ~ 正无穷]的正整数集合
    // 有操作1会移除集合中的最小整数
    // 有操作2会向集合中添加一个整数

    // 逆向思维: 维护无穷集合a 反过来 维护有限集合b -> b = 不在集合a中的元素
    // 操作1: 寻找不存在集合b中的最小值, 加入集合b
    // 操作2: 删除一个b中的元素

    // 针对操作1: 如果没有操作2, 实际只需一个计数器就能完成;
    // 因此, 保留这个计数器, 同时维护操作2会产生的影响

    class SmallestInfiniteSet {

        int top; // <= top 的元素才可能在集合b中
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // <= top 且不在b中的元素
        boolean[] pqSet = new boolean[1009]; // pqSet[i] <-> pq.contains(i);

        public SmallestInfiniteSet() {
            top = 0;
        }

        public int popSmallest() {
            // 弹出a中的最小值 -> 向b中加入一个"不在b中"的最小元素
            if(!pq.isEmpty()) { // 情况1 -> 加入pq中的元素 -> 移除pq中的一个元素
                int c = pq.poll();
                pqSet[c] = false;
                return c;
            } else { // 情况2 -> top上移
                return ++top;
            }

        }

        public void addBack(int num) {
            if(num <= top) {
                if(!pqSet[num]) {
                    pqSet[num] = true;
                    pq.offer(num);
                }
            }
        }

    }

}
