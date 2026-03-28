package ErFen;

public class a744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int pos = FindThePosOfFlag(letters,target);
        return (pos < letters.length) ?
                letters[pos] : letters[0];
    }
    public int FindThePosOfFlag(char[] nums,char flag) {
        // 修改成 R右侧是“大于”
        int n = nums.length;
        int l = 0; // 区间左边界
        int r = n-1; // 区间右边界
        int mid;  // 区间中间位置

        while(r>=l) {
            mid = (r+l)/2;
            if(nums[mid]-'a'<=flag-'a') {
                l = mid+1; // mid是检查过的位置，l左侧的都小于flag
            } else {
                r = mid-1; // r右侧的都大于flag
            }
        }
        return l;
    }
}
