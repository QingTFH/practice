package 不定长滑窗;

public class a1658 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
        }
        if(sum == x) {
            return n;
        }

        int sumNums=0;
        int l=0,r=0,maxLen=0; //滑窗找出 最短的 和恰好为sum-x 的子数组窗口
        for(;r<n;r++) {
            sumNums+=nums[r];
            while (r >= l && sumNums > sum-x) {
                sumNums -= nums[l];
                l++;
            }
            if(sumNums == sum-x) {
                maxLen = Math.max(maxLen,r-l+1);
            }
        }

        return (maxLen==0) ? -1:n-maxLen;
    }
}
