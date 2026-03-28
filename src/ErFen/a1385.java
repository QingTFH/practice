package ErFen;

import java.util.Arrays;

public class a1385 {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int[] sortedArr2 = Arrays.stream(arr2)
                            .sorted()
                            .toArray(); // 流排序默认升序
        int ans = 0;
        for (int j : arr1) {
            int pos = FindThePosOfFlag(sortedArr2, j); // 找到arr2[pos]最接近j的绝对值
            //System.out.println("pos: "+pos);

            if(Math.abs(sortedArr2[pos]-j) > d) {
                ans++;
            }
        }
        return ans;
    }

    public int FindThePosOfFlag(int[] nums,int flag) {
        int n = nums.length;
        int l = 0; // 区间左边界
        int r = n-1; // 区间右边界
        int mid;  // 区间中间位置

        while(r>=l) {
            mid = (r+l)/2;
            if(nums[mid]<flag) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        //返回绝对值最接近的位置
        if(l == n) { // n-1的位置最接近
            return n-1;
        } else if(r == -1) {
            return 0;
        }
        return Math.abs((nums[l]-flag)) <= Math.abs((nums[r]-flag)) ?
                l : r;
    }
}
