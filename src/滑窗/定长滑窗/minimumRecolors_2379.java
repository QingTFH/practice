public class minimumRecolors_2379 {
    int max_n = 100;
    public int minimumRecolors(String blocks, int k) {
        int ans=max_n;
        int n = blocks.length();
        int sum_W = 0;
        for(int r = 0;r < n;r++){
            sum_W += (isWhite(blocks.charAt(r)) ? 1:0);
            int l = r-k+1;
            if(l < 0)
                continue;

            ans = Math.min(ans,sum_W);
            sum_W -= (isWhite(blocks.charAt(l)) ? 1:0);
        }
        return ans;
    }
    public boolean isWhite(char a){
        return a == 'W';
    }
}
