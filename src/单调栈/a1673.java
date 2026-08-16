package 单调栈;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class a1673 {

    // 同402, 剩余长度k等价于删减次数len-k

    public int[] mostCompetitive(int[] nums, int k) {
        if(k == nums.length) {
            return nums;
        }

        Deque<Integer> stack = new ArrayDeque<>(); // 单调递增栈
        int left = nums.length - k; // 剩余删除次数
        int i = 0; // 遍历到的位置
        for (; i < nums.length && left > 0; i++) {
            while(!stack.isEmpty() && left > 0 && nums[i] < stack.peek()) {
                left--;
                stack.pop();
            }
            stack.push(nums[i]);
        }

        // 如果left>0 从后往前删;
        while(left-- > 0) {
            stack.pop();
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while(!stack.isEmpty()) {
            ans.add(stack.pop());
        }
        Collections.reverse(ans);

        System.out.println(ans);

        for(; i<nums.length; i++) {
            ans.add(nums[i]);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();

    }

}
