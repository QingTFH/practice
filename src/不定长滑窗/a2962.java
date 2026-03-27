public class a2962 {
    public long countSubarrays(int[] nums, int k) {
        int max = 0; // nums[i] >= 1
        int n = nums.length;
        for(int i=0;i<n;i++) {
            max = Math.max(max,nums[i]);
        }

        int l=0,r=0,cnt=0;
        long ans = 0;
        for(;r<n;r++) {
            cnt += (nums[r]==max) ? 1:0;
            while(r>=l && cnt >= k) { // 越长越合法，尽量变短
                cnt -= (nums[l++]==max) ? 1:0;
            }
            //此时 [l,r]不合法，但是[l-1,r]恰好合法，也就是左侧从0到l-1都合法，
            //也就是右端为r时，共有l个子数组合法
            ans+=l;
        }
        return ans;
    }
}
