package 不定长滑窗;

public class a713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0,r=0,n=nums.length,sum=0;
        int mult = 1; // 当前窗口乘积

        for(;r<n;r++) {
            mult *= nums[r];
            while(r>=l && mult >= k) { // 合法化
                mult /= nums[l];
                l++;
            }
            //此时右侧多了一个nums[r]
            //若，假设上一次循环的全部子数组都已进入计数器
            //那么，只有“带有nums[r]的子数组”在本次循环需要加入计数器
            //  [r,r],[r-1,r]------[l,r]，共r-l+1个
            //下一次循环前，则可以保证当前窗口内全部子数组都已加入计数器
            //归纳法可得这个方法不重不漏

            sum += r-l+1;
        }

        return sum;
    }
}
