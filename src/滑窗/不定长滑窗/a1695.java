import java.util.HashMap;
import java.util.Map;

public class a1695 {
    public int maximumUniqueSubarray(int[] nums) {
        //如果遇到nums[r]已经在记录中，则l=map[nums[r]]+1
        //所以需要哈希表记录每个元素的最后出现位置，需要前缀和快速处理l变化后的sum
        int n=nums.length,l=0,r=0,max=0,sum=0;
        Map<Integer,Integer> map = new HashMap<>();//元素->最后出现位置
        int[] cnt = new int[n];//包含i位置的前缀和
        for(;r<n;r++){
            int x = nums[r];//x进入窗口

            cnt[r] = x;
            if(r!=0)
                cnt[r] += cnt[r-1];
            //处理前缀和数组

            sum += x;
            int pos = map.getOrDefault(x,-1);
            if(l<=pos){
                if(l>0)
                    sum += cnt[l-1];//避免多次减去
                l=pos+1;
                sum -= cnt[l-1];
            }//窗口合法化
            map.put(x,r);

            max = Math.max(max,sum);
            //System.out.println(sum);
        }
        return max;
    }
}
