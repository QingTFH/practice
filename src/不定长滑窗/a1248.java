public class a1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        return solu(nums,k)-solu(nums,k+1);
    }
    private int solu(int[] nums, int goal) { // 返回 奇数个数 大于等于 goal 的子数组个数
        int l=0,r=0,n=nums.length;
        int ans = 0;
        int cnt = 0; // 当前窗口的奇数个数
        for(;r<n;r++) {
            cnt += isOdd(nums[r]) ? 1:0;
            while(r>=l && cnt >= goal) {
                cnt -= isOdd(nums[l++]) ? 1:0;
            }
            ans+=l;
        }
        return ans;
    }
    private boolean isOdd(int num) {
        return num % 2 == 1;
    }
}
