import java.util.HashMap;
import java.util.Map;

public class a2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        //记录频率哈希表
        Map<Integer,Integer> map = new HashMap<>();
        int l=0,r=0,n=nums.length,max=0;
        for(;r<n;r++){
            int x = nums[r];//x进入窗口
            map.merge(x,1,Integer::sum);
            int f = map.getOrDefault(x,0);//f是x出现次数
            while(f>k){
                map.merge(nums[l],-1,Integer::sum);//nums[l]出现的次数-1
                l++;
                f = map.get(x);
            }
            max = Math.max(max,r-l+1);
            //System.out.println("l="+l+" r="+r);
        }
        return max;
    }
}
