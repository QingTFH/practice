package ErFen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class a2476 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> tree = new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>(queries.size());
        BFS(tree,root); // 将树拍成升序数组。

        int n = queries.size();
        for(int i=0; i<n; i++) {
            List<Integer> tmpAns = new ArrayList<>();
            int min = -1;
            int max = -1;
            int value = queries.get(i);
            int max_pos = FindThePosOfFlag(tree,value);
            if(max_pos != tree.size()) {
                max = tree.get(max_pos);
                if(max == value) {
                    min = value;
                } else {
                    int min_pos = FindThePosOfFlag(tree,value-1);
                    if(min_pos != 0) {
                        min = tree.get(min_pos);
                    }
                }
            } else {
                int min_pos = FindThePosOfFlag(tree,value-1);
                if(min_pos != 0) {
                    min = tree.get(min_pos);
                }
            }
            tmpAns.add(min);
            tmpAns.add(max);
            ans.add(tmpAns);
        }
        return ans;
    }

    private void BFS(List<Integer> tree,TreeNode root) {
        if(root.left != null) {
            BFS(tree,root.left);
        }
        tree.add(root.val);
        if(root.right != null) {
            BFS(tree,root.right);
        }
    }

    public int FindThePosOfFlag(List<Integer> nums,int flag) {
        int n = nums.size();
        int l = 0;
        int r = n-1;
        int mid;
        while(r>=l) {
            mid = (r+l) >>> 1;
            if(nums.get(mid)<flag) { // 小于 | 大于等于
                l = mid+1; // mid是检查过的位置
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}





