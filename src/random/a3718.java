package random;

import java.util.Arrays;
import java.util.HashSet;

public class a3718 {

    // 一次遍历哈希set + 枚举k的倍数

    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);

        for (int cnt = 1; ; cnt++) {
            int n = cnt * k;
            if (!set.contains(n))
                return n;
        }
    }

}
