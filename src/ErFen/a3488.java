package ErFen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a3488 {

    private HashMap<Integer, ArrayList<Integer>> posMap = new HashMap<>(); // 元素值 -> 该值的位置list

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        for(int i=0; i<n; i++) {
            int value = nums[i];
            posMap.computeIfAbsent(value,k->new ArrayList<>()).add(i);
        }

        int m = queries.length;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<m; i++) {
            int pos = queries[i];
            int value = nums[pos];
            System.out.println("pos = "+pos+" value = "+value);
            ans.add(i,query(pos,value,nums.length));
        }
        return ans;
    }

    public int query(int targetPos, int value, int len) {
        ArrayList<Integer> list = posMap.get(value);
        if(list.size() == 1) {
            return -1;
        }
        int n = list.size();
        int pos = FindThePosOfFlag(list,targetPos);
        // 由于targetPos一定在list内，所以pos一定在[0,n-1]内
        int l,r;
        if(pos == 0) {
            l = list.get(n-1);
            r = list.get(1);
        } else if(pos == n-1) {
            l = list.get(n-2);
            r = list.get(0);
        } else {
            l = list.get(pos-1);
            r = list.get(pos+1);
        }
        return Math.min(direction(l,targetPos,len), direction(r,targetPos,len));
    }

    public int FindThePosOfFlag(ArrayList<Integer> nums,int flag) {
        int n = nums.size();
        int l = 0;
        int r = n-1;
        int mid;
        while(r>=l) {
            mid = (r+l) >>> 1;
            if(nums.get(mid)<flag) { // 小于 | 大于等于
                l = mid+1; // mid是检查过的位置
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    private int direction(int a,int b,int len) { // 数组内 两个索引的距离
        return Math.min(Math.abs(a-b),len-Math.abs((a-b)));
    }
}
