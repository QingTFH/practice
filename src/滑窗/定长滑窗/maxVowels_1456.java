public class maxVowels_1456 {
    public int maxVowels(String s, int k) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += (isVowel(s.charAt(i)) ? 1:0);
        }//初始化窗口,0->k-1
        int ans = sum;
        int n = s.length();
        for(int r=k;r<n;r++){
            sum += (isVowel(s.charAt(r)) ? 1:0);
            sum -= (isVowel(s.charAt(r-k)) ? 1:0);
            ans = Math.max(ans,sum);
            if(ans == k)
                return k;
        }

        return ans;
    }
    public boolean isVowel(char a){
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }
}
