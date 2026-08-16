import java.util.HashMap;
import java.util.Map;

public class maximumSubarraySum_2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans=0;
        int cnt=0;
        long sum = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n = nums.length;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            if(map.containsKey(nums[r])){
                map.put(nums[r],map.get(nums[r])+1);
            }
            else{
                map.put(nums[r],1);
                cnt++;
            }

            int l = r-k+1;
            if(l<0)
                continue;

            if(cnt == k){
                ans = Math.max(ans,sum);
            }

            sum-=nums[l];
            if(map.get(nums[l])==1){
                map.remove(nums[l]);
                cnt--;
            }
            else
                map.put(nums[l],map.get(nums[l])-1);
        }

        return ans;
    }
}
