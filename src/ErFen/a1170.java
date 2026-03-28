package ErFen;

import java.util.Arrays;

public class a1170 {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int len = queries.length;
        int lenWords = words.length;

        int[] funcWords = new int[lenWords];
        for(int i = 0; i<lenWords; i++) {
            funcWords[i] = wordToF(words[i]);
            //System.out.println(funcWords[i]);
        }
        int[] sortedFuncWords = Arrays.stream(funcWords).sorted().toArray();

        int[] ans = new int[len];
        for(int i = 0; i<len; i++) {
            int func = wordToF(queries[i]);
            int pos = FindThePosOfFlag(sortedFuncWords,func); // pos是第一个>func的位置
            // 也就是[pos,n-1]都合法 共n-pos个
            // pos边界值:0,n
            ans[i] = lenWords - pos;
        }

        return ans;
    }

    public int wordToF(String word) {
        if (word == null || word.isEmpty()) return 0;
        int min = word.chars().min().orElse(0);
        return (int)word.chars().filter(c -> c == min).count();
    }

    public int FindThePosOfFlag(int[] nums,int flag) {
        //二分查找 第一个>=flag的数 在nums中的位置
        //升序数组!
        int n = nums.length;
        //定义区间量：闭区间内部是未判定的位置
        //左侧的都是小于flag的,右侧的都是大于等于flag的
        int l = 0; // 区间左边界
        int r = n-1; // 区间右边界
        int mid;  // 区间中间位置

        while(r>=l) {
            mid = (r+l)/2;
            if(nums[mid]<=flag) {
                l = mid+1; // mid是检查过的位置，l左侧的都小于flag
            } else {
                r = mid-1; // r右侧的都大于flag
            }
        }
        // 查找结束后，l左侧都是小于flag的，r右侧都是大于等于flag的，
        // 换言之 nums[l]=nums[R+1]=flag（如果右flag）
        return l;

        //如果不存在"第一个>=flag的数",返回n
    }

}
