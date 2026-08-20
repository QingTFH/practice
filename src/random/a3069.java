package random;

import java.util.ArrayList;

public class a3069 {

    // 简单的题目就不复杂化, 一次遍历nums并构造两个数组, 第二次遍历arr2将其追加到arr1后, O(n)复杂度, 难道还可以优化？
    // 灵茶山的题解也是O(n), 那就没问题
    // 似乎可以用int[]来代替ArrayList以进行优化, 不过麻烦一些

    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>(), arr2 = new ArrayList<>();

        // 模拟
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (arr1.get(arr1.size() - 1) > arr2.get(arr2.size() - 1))
                arr1.add(nums[i]);
            else
                arr2.add(nums[i]);
        }

        arr1.addAll(arr2);
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = arr1.get(i);
        }

        return result;
    }

}
