package 不定长滑窗;

import java.util.Arrays;

public class a2779 {
    public int maximumBeauty(int[] nums, int k) {
        //重写了子数组的定义：不用相连，只需存在(比如[1,2,3,4,5]中，[1,3,5]也可认为是子数组)

        Arrays.sort(nums); //升序排列
        int l=0,r=0,maxLen=0;
        int n = nums.length;
        for(;r<n;r++) {
            while (r>=l && nums[r]-nums[l]>2*k) { // 检查进入的元素，并使窗口合法化
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);

        }

        return maxLen;
    }
}
