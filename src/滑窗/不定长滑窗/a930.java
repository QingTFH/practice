public class a930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return solu(nums,goal) - solu (nums,goal+1); // 恰好等于goal
    }

    private int solu(int[] nums, int goal) { // 返回 "'特征值' >= goal" 的子数组个数
        int l=0,r=0,n=nums.length;
        int ans = 0;
        int cnt = 0; // 当前窗口的特征值cnt
        for(;r<n;r++) {
            cnt += nums[r];
            while(r>=l && cnt >= goal) {
                cnt -= nums[l++];
            }
            // 此时 [l,r]的 cnt 恰好小于 goal
            // 也就是 [l-1,r]|[l-2,r]|...|[0,r]的 cnt 恰好大于等于goal,有l个
            ans+=l;
        }
        return ans;
    }
}
