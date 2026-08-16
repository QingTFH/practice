package 常用数据结构.队列;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class a950 {

    // 出队 + 队首后移 ---逆变换--> 队尾前移 + 入队
    // 丛大的一边开始操作

    public int[] deckRevealedIncreasing(int[] deck) {
        int[] t = Arrays.stream(deck).sorted().toArray();
        Queue<Integer> result = new ArrayDeque<>();
        for (int i = t.length - 1; i >= 0; i--) {
            if(!result.isEmpty()) { // 队尾前移
                result.offer(result.poll());
            }
            result.offer(t[i]);
        }

        // 最后入队的最小 -> 最先出队的最大
        for (int i = t.length - 1; i >= 0; i--) {
            t[i] = result.poll();
        }
        return t;
    }

}
