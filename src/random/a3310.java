package random;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class a3310 {

    // 删除所有 可能有bug的方法 后, 如果有正常方法调用了被删除的方法, 返回原数组; 否则返回剩余方法的数组

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // 构建邻接表
        ArrayList<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] c : invocations) {
            graph[c[0]].add(c[1]);
        }


        boolean[] mark = new boolean[n]; // 标记true的是可疑方法
        Queue<Integer> queue = new ArrayDeque<>(); // BFS队列

        queue.offer(k);
        mark[k] = true;
        while (!queue.isEmpty()) {
            int c = queue.poll(); // 可疑方法的名称
            for (int i : graph[c]) { // 它的出点集合
                if(!mark[i]) { // i 还没被标记
                    queue.offer(i);
                    mark[i] = true;
                }
            }
        }

        for (int[] e : invocations) {
            if (!mark[e[0]] && mark[e[1]]) { // 存在正常方法 -> 可疑方法的边
                List<Integer> result = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    result.add(i);
                }
                return result;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!mark[i]) result.add(i);
        }
        return result;
    }

}
