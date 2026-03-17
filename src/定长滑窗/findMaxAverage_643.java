public class findMaxAverage_643 {
    public double findMaxAverage(int[] nums, int k) {
        double ans = -10000;
        int n = nums.length;
        int sum = 0;
        double average = 0;
        for(int r = 0;r < n ;r++){
            sum += nums[r];
            int l = r - k + 1;
            if(l<0)
                continue;
            average = (double) sum / k;
            ans = Math.max(average,ans);
            sum -= nums[l];
        }
        return ans;
    }
}
