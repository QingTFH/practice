package 常用数据结构.前缀和;

import java.util.HashMap;

public class a1524 {

    // 和为奇数的子数组数目

    public static final int MOD = (int) (1e9+7);

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefix_sum_mod = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix_sum_mod[i+1] = (prefix_sum_mod[i] + arr[i]) % 2;
        }

        int[] mod = new int[2];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if(prefix_sum_mod[i+1] == 0) {
                result = (result + mod[1]) % MOD;
            } else {
                result = (result + mod[0] + 1) % MOD;
            }
            mod[prefix_sum_mod[i+1]] = (mod[prefix_sum_mod[i+1]] + 1) % MOD;
        }

        return result;
    }

}
