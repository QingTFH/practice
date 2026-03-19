package 不定长滑窗;

import java.util.Arrays;

public class a1838 {
    public int maxFrequency(int[] nums, int k) {
        //排序
        //对于窗口右侧进入的元素a，窗口中的元素都要变成a->多消耗(a-nums[r-1]) * (r-l+1)
        Arrays.sort(nums);
        int r=0,l=0,n=nums.length;
        long sum = 0; //目前消耗的次数
        long maxLen=0;
        for(;r<n;r++) {
            if(r>=1) { //nums[r]进入后，需要多消耗的次数
                sum += (long) (nums[r] - nums[r - 1]) * (r-l); //这一步注意转换
            }

            //合法化
            while(r>l && sum > k) {
                sum -= nums[r]-nums[l];
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }
        return (int)maxLen;
    }
    //居然会爆int
}
