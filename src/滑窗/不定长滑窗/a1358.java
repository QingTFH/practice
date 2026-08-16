public class a1358 {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int l=0,r=0,n=s.length();
        int[] cnt = new int[3];

        for(;r<n;r++) {
            cnt[s.charAt(r)-'a']++;
            while(r>=l && legal(cnt)) {
                cnt[s.charAt(l)-'a']--;
                l++;
            }
            //跳出循环后，[l,r]恰好不合法，但是[l-1,r],[l-2,r]....都合法
            //与统计过的子数组不同的是，本次所有加入了r的子数组都不重复；
            //也就是统计 l-1 l-2 ... 0 的个数，一共l个
            ans += l;
        }

        return ans;
    }
    private boolean legal(int[] cnt) {
        return cnt[0]>0 && cnt[1]>0 && cnt[2]>0;
    }
}
