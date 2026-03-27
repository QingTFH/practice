package 不定长滑窗;

public class _banzi {
    public int boolToInt(boolean a){
        return a ? 1:0;
    }
    private boolean isVowel(char a){
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }
    public int maxDingChang_HuaChuang(int[] a,int k){
        int max=0,sum=0,n=a.length;
        for(int r=0,l=0;r<n;r++){
            sum+=a[r];
            max=Math.max(sum,max);
            l=r-k+1;
            if(l>=0){
                sum-=a[l];
            }
        }
        return max;
    }

    //“恰好等于” 或 “大于等于”的模板
    private int NumOfGreatEqualThanGoal(int[] nums, int goal) { // 返回 "和"大于等于 goal 的子数组个数
        int l=0,r=0,n=nums.length;
        int ans = 0;
        int cnt = 0; // 当前窗口的和
        for(;r<n;r++) {
            cnt += nums[r];
            while(r>=l && cnt >= goal) {
                cnt -= nums[l++];
            }
            // 此时 [l,r]的sum 恰好小于goal
            // 也就是 [l-1,r]|[l-2,r]|...|[0,r]的sum 恰好大于等于goal,有l个
            ans+=l;
        }
        return ans;
    }
}
