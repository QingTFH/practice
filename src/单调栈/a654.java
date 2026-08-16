package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class a654 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
     * 思路：
     * 对于每一个节点，它的父节点会是“数组中左边/右边的第一个大于他的元素中较小的那个”，
     * 所以我们只要找到每一个节点的“左边第一个大于他的元素”和“右边第一个大于他的元素”，就可以知道它的父节点是谁；此处使用单调栈
     * 最后，串联起来即可；
     */


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 1. 找左边第一个最大值
        int[] left = findLeftFirstBigger(nums);

        // 2. 找右边第一个最大值
        int[] right = findRightFirstBigger(nums);

        // 3. 创建每一个元素的节点
        TreeNode[] treeNodes = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            treeNodes[i] = new TreeNode(nums[i]);
        }

        // 4. 串联节点
        TreeNode root = null;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] == -1 && right[i] == -1) {
                root = treeNodes[i];
            } else {
                if (left[i] == -1) { // 是右边的子节点
                    treeNodes[right[i]].left = treeNodes[i];
                } else if (right[i] == -1) { // 是左边的子节点
                    treeNodes[left[i]].right = treeNodes[i];
                } else { // 是两边中较小者的子节点
                    int pos = nums[right[i]] >= nums[left[i]] ? left[i] : right[i];
                    if (i < pos) { // 是右边的子节点
                        treeNodes[right[i]].left = treeNodes[i];
                    } else {
                        treeNodes[left[i]].right = treeNodes[i];
                    }
                }
            }
        }

        return root;
    }

    public int[] initialNums(int length, int initial) {
        int[] ans = new int[length];
        Arrays.fill(ans, initial);
        return ans;
    }

    public int[] findLeftFirstBigger(int[] nums) {
        int[] ans = initialNums(nums.length, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标
        for (int i = nums.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) { // 尝试出栈
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] findRightFirstBigger(int[] nums) {
        int[] ans = initialNums(nums.length, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // 存储下标
        for (int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]) { // 尝试出栈
                ans[stack.pop()] = i;
            }
            stack.push(i);
        }
        return ans;
    }


}
