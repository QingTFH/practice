public class a209 {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,minLen=Integer.MAX_VALUE;
        int n = nums.length;
        int sum = 0;//当前窗口和
        for(;r<n;r++) {
            sum+=nums[r];
            if(sum >= target) {
                while(sum - nums[l] >= target) {
                    sum -= nums[l];
                    l++;
                }
                minLen = Math.min(minLen,r-l+1);
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
