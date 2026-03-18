public class a2516 {
    public int takeCharacters(String s, int k) {
        int[] sum = new int[3]; //数组中总个数，相当于一开始就取走所有字母
        int n = s.length();
        for(int i=0;i<n;i++) {
            sum[s.charAt(i)-'a']++;
        }
        if(sum[0] < k || sum[1] < k || sum[2] < k ) {
            return -1;
        }

        int l=0,r=0,maxLen=0;
        //sX代表窗口中X的总数,sX<=sumX-k,越长越合法
        for(;r<n;r++) {
            int x = s.charAt(r);
            sum[x-'a'] --; //将x放回数组
            while(sum[x-'a']<k) {
                sum[s.charAt(l)-'a']++;//左端取出
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
        }
        return n-maxLen;
    }
    /*
     * 多个元素记得开数组
     * 这种逆向滑窗的问题，窗口内个数可以直接在总数上扣除
     *
     */
}
