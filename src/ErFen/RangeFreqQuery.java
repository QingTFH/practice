package ErFen;

import java.util.ArrayList;
import java.util.HashMap;

class RangeFreqQuery {

    HashMap<Integer, int[]> map;
    // key:nums的元素x   value:x的下表集合，升序

    public RangeFreqQuery(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> tempMap = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++) {
            int value = arr[i];
            tempMap.computeIfAbsent(value,k->new ArrayList<>()).add(i);
        }

        map = new HashMap<>(tempMap.size());
        for(Integer value : tempMap.keySet()) {
            ArrayList<Integer> list = tempMap.get(value);
            int m = list.size();
            int[] posList = new int[m];
            for(int i=0;i<m;i++) {
                posList[i] = list.get(i);
            }
            map.put(value,posList);
        }
    }

    public int query(int left, int right, int value) {
        int[] list = map.get(value);
        if(list == null) {
            return 0;
        }
        int l = FindThePosOfFlag(list,left); // 大于等于left的第一个位置,该位置合法
        int r = FindThePosOfFlag2(list,right); // 大于right的第一个位置，该位置非法
        //[l,r),左闭右开
        return r-l;
    }

    public int FindThePosOfFlag(int[] nums,int flag) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int mid;
        while(r>=l) {
            mid = (r+l)/2;
            if(nums[mid] < flag) { // 小于 | 大于等于
                l = mid+1; // mid是检查过的位置
            } else {
                r = mid-1;
            }
        }
        return l;
    }

    public int FindThePosOfFlag2(int[] nums,int flag) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int mid;
        while(r>=l) {
            mid = (r+l)/2;
            if(nums[mid] <= flag) { // 小于 | 大于等于
                l = mid+1; // mid是检查过的位置
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}

/*
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
