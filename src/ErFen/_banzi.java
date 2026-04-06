package ErFen;

public class _banzi {

    // 升序数组 二分查:找第一个>=flag的数 在nums中的位置
    //定义区间：闭区间内部是未判定的位置
    //左侧的都是"小于"flag的,右侧的都是"大于等于"flag的 ("等于"的位置可自由选择)
    // 查找结束后，l左侧都是小于flag的，r右侧都是大于等于flag的，
    // 换言之 nums[l]=nums[R+1]=flag（如果右flag）
    //如果不存在"第一个>=flag的数",返回n
    public int FindThePosOfFlag(int[] nums,int flag) {
        int n = nums.length;
        int l = 0;
        int r = n-1;
        int mid;
        while(r>=l) {
            mid = (r+l) >>> 1;
            if(nums[mid]<flag) { // 小于 | 大于等于
                l = mid+1; // mid是检查过的位置
            } else {
                r = mid-1;
            }
        }
        return l;
    }
}
