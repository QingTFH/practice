package ErFen;

import java.util.Arrays;

public class a2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        int[] sumNums = new int[sortedNums.length];
        for(int i=0,sum=0;i<sortedNums.length;i++) {
            sum += sortedNums[i];
            sumNums[i] = sum; // sumNums[i] = (sorted) nums[0]~~nums[i]的和
        }
        int m = queries.length;
        int[] ans = new int[m];
        for(int i = 0; i<m; i++){
            int pos = FindThePosOfFlag(sumNums,queries[i]);
            // 最长的合法子序列是sortedNum[0~pos-1];
            ans[i] = pos;
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
            if(nums[mid]<=flag) { // 小于等于 | 大于
                l = mid+1; // mid是检查过的位置，l左侧的都小于flag
            } else {
                r = mid-1; // r右侧的都大于flag
            }
        }
        return l;
    }
 }
