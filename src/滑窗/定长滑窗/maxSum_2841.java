import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class maxSum_2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer,Integer> docu = new HashMap<>();//记录窗口中元素(key值)出现的次数value
        int doc = 0;//个数
        long sum = 0;
        long ans = 0;
        int n = nums.size();
        for(int r = 0;r<n;r++){
            int R = nums.get(r);
            sum += R;
            if(!docu.containsKey(R)){
                doc ++;
                docu.put(R,1);
            }
            else
                docu.put(R,docu.get(R)+1);

            int l = r-k+1;
            if(l < 0)
                continue;
            int L = nums.get(l);

            if(doc >= m)
                ans = Math.max(ans,sum);

            sum -= L;
            if(docu.get(L) == 1){
                doc --;
                docu.remove(L);
            }
            else
                docu.put(L,docu.get(L)-1);
        }
        return ans;
    }
}
