package 常用数据结构.枚举技巧.枚举右维护左;

import java.util.HashMap;

public class a1010 {

    // (time[i] + time[j]) % 60 == 0 --> (time[i] % 60) + (time[j] % 60) == 60或0

    public int numPairsDivisibleBy60(int[] time) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>(); // time[i] % 60 -> i

        for (int i = 0; i < time.length; i++) {
            int t = time[i] % 60;
            result += map.getOrDefault(-t, 0)
                    + map.getOrDefault(60 - t, 0);
            // 由于只存储了整数, -t存在的情况只有t = 0
            map.merge(t, 1, Integer::sum);
        }

        return result;
    }

}
