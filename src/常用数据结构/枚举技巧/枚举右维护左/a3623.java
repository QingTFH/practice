package 常用数据结构.枚举技巧.枚举右维护左;

import java.util.HashMap;

public class a3623 {

    // points[i] = {x, y}, 代表笛卡尔平面上的一个点的坐标;
    // points[i] == points[j] 当且仅当 i == j;
    // 返回值 = 四个点构成的凸四边形中, 存在两条水平直线的四边形数

    // 每个高度上的水平直线组数为 C(p,2);

    public static final int MOD = (int) (1e9+7);

    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>(); // y值 -> 该值上的点数;

        long result = 0;

        for (int[] point : points) {
            map.merge(point[1], 1, Integer::sum);
        }

        int edgeSum = 0;
        for(int p : map.values()) {
            long edge = (long) (p % MOD) * ((p-1) % MOD) / 2;
            edge %= MOD;

            result += ((edge % MOD) * (edgeSum % MOD));
            result %= MOD;

            edgeSum += (int) (edge % MOD);
            edgeSum %= MOD;
        }

        return (int)result;
    }

}
