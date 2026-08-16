public class getAverages_2090 {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        int sum = 0;
        for(int i=0;i<k&&i<n;i++){
            ans[i] = -1;
        }
        for(int i=n-1;i>=n-k&&i>=0;i--){
            ans[i] = -1;
        }
        for(int r = 0;r<n;r++){
            sum += nums[r];
            if(r - 2*k < 0){
                continue;
            }
            //r >= 2k -> l = 0 , medium = k
            ans[r-k] = sum/(2*k+1);

            sum -= nums[r-2*k];
        }
        return ans;
    }
}
