public class a3306 {
    public long countOfSubstrings(String word, int k) {
        return NumOfGreatEqualThanGoal(word,k) - NumOfGreatEqualThanGoal(word,k+1);
    }
    private long NumOfGreatEqualThanGoal(String word, int goal) { // 返回 "和"大于等于 goal 的子数组个数
        int l=0,r=0,n=word.length();
        long ans = 0;
        int[] cnt = new int[6];
        for(;r<n;r++) {
            cnt[charToPos(word.charAt(r))] += 1;
            while(r>=l && legal(cnt,goal)) {
                cnt[charToPos(word.charAt(l++))] -= 1;
            }
            ans+=l;
        }
        return ans;
    }
    private int charToPos(char x) {
        switch (x){
            case 'a':
                return 0;
            case 'e':
                return 1;
            case 'i':
                return 2;
            case 'o':
                return 3;
            case 'u':
                return 4;
            default:
                return 5;
        }
    }
    private boolean legal(int[] a,int goal) {
        return a[0] >= 1 && a[1] >= 1 && a[2] >= 1 && a[3] >= 1 && a[4] >= 1 && a[5] >= goal;
    }
}
