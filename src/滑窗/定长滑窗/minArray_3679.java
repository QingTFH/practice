import java.util.HashMap;
import java.util.Map;

public class minArray_3679 {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int n = arrivals.length;
        int ans=0;
        for(int r = 0;r<n;r++){
            int x = arrivals[r];
            int c = map.getOrDefault(x,0);//如果没有key=x，那么c=0
            if(c==m){
                ans++;
                arrivals[r]=0;
            }else{
                map.put(x,c+1);
            }

            int l = r-w+1;
            if(l<0) continue;
            map.merge(arrivals[l],-1,Integer::sum);
        }
        return ans;
    }
}
