import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

public class a3634 {
    public int minRemoval(int[] nums, int k) {
        //先排序nums,然后滑窗找到最长合法数组，返回nums.length-max
        Arrays.sort(nums);
        int n=nums.length,l=0,r=0,max=0;
        for(;r<n;r++){
            while((long)nums[r]>(long)k*nums[l]){//注意避免溢出.....
                l++;
            }
            max = Math.max(max,r-l+1);
        }
        return n-max;
    }
}
