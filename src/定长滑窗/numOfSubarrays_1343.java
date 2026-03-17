public class numOfSubarrays_1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans=0;
        int n = arr.length;
        int sum = 0;//子数组的和
        for(int r = 0;r < n ;r++){
            sum += arr[r];//完整子数组
            int l = r - k + 1;
            if(l<0)
                continue;
            if(sum/k >= threshold)
                ans ++;

            sum -= arr[l];
        }

        return ans;
    }
}
