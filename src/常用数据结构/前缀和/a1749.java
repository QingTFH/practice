package 常用数据结构.前缀和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class a1749 {

    // 任意子数组[l, r]的和 = prefix[r+1] - prefix[l]
    // 要让他的绝对值尽量大, 要么prefix[r+1]尽量小并且prefix[l]尽量大, 要么反过来
    // 因此, 将前缀和中的最大值和最小值组合即可

    public int maxAbsoluteSum(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, prefix_sum = 0;
        for (int num : nums) {
            prefix_sum += num;
            max = Math.max(max, prefix_sum);
            min = Math.min(min, prefix_sum);
        }

        return max - min;
    }

}
