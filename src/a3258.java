public class a3258 {
    public int countKConstraintSubstrings(String s, int k) {
        int[] cnt = new int[2];
        int l=0,r=0,n=s.length(),ans=0;
        for(;r<n;r++) {
            cnt[s.charAt(r)-'0']++;
            while(r>=l && (cnt[0] > k && cnt[1] > k)) {
                cnt[s.charAt(l)-'0']--;
                l++;
            }
            ans += r-l+1;
        }

        return ans;
    }
}
