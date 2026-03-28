package ErFen;

public class a2529 {
    public int maximumCount(int[] nums) {
        //二分找到 pos1 >=0 和 pos2 >=1
        // 其中pos1左侧都是负数，也就是[0,pos1-1] 共pos1个
        // pos2及右侧都是正数，也就是[pos2,n-1]，共n-po2个
        int pos1 = FindThePosOfFlag(nums,0);
        int pos2 = FindThePosOfFlag(nums,1);
        int n = nums.length;
        return Math.max(pos1,n-pos2);
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
            if(nums[mid]<flag) {
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
