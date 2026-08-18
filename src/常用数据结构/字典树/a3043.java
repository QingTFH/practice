package 常用数据结构.字典树;

import java.util.HashSet;

public class a3043 {

    // 朴素想法: 嵌套循环遍历arr1(x)和arr2(y), 比较x和y的前缀 -> O(n^2)
    // 优化想法: 遍历过的元素希望不要再次遍历 -> 记录他的信息, 尝试O(1)获取 -> HashSet存x的前缀
    // 这一题用字典树似乎和hashset不相上下

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> pre = new HashSet<>();
        for (int x : arr1) {
            while(x > 0) {
                pre.add(x);
                x /= 10;
            }
        }

        int result = 0;
        for (int y : arr2) {
            while(y > 0) {
                if(pre.contains(y)) {
                    result = Math.max(result, y);
                    break; // 再剥离前缀也不会比当前的这个大, 直接快速失败
                }
                y /= 10;
            }
        }

        int ans = 0; // Integer.toString(result).length需要考虑result = 0的情况, 以及性能上似乎不如这个
        while(result > 0) {
            ans++;
            result /= 10;
        }
        return ans;
    }

}
