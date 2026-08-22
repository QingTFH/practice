package 链表_二叉树_回溯.链表;

import java.util.HashSet;
import java.util.Set;

public class a3790 {

    // 假设已有整数x = 111, 那么1111 % k = (10x + 1) % k = (10 % k * x % k) + 1 % k

    public int minAllOneMultiple(int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1, mod = 1 % k; i <= k; i++) { // i是位数
            if (mod == 0)
                return i;
            if (set.contains(mod))
                return -1;
            set.add(mod);
            mod = ((10 % k * mod) % k + 1 % k) % k;
        }

        return -1;
    }

}
