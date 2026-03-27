package 不定长滑窗;

public class a2302 {
    public long countSubarrays(int[] nums, long k) {
        int l=0,r=0,n=nums.length;
        long sum = 0;
        long ans = 0; //ans_Max = sum(n) = n*(n+1)/2 -> long

        for(;r<n;r++) {
            sum+=nums[r];
            while(r>=l && (sum*(r-l+1)>=k)){
                sum-=nums[l];
                l++;
            }
            ans += r-l+1;
        }

        return ans;
    }
}
