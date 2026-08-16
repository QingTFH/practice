public class a1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        //先统计cost数组，滑窗取最长值
        int n= s.length(),l=0,r=0,max=0;
        int[] costNum = new int[n];
        for(int i=0;i<n;i++){
            costNum[i] = Math.abs(s.charAt(i)-t.charAt(i));
            if(i>0)
                costNum[i] += costNum[i-1];
        }
        for(;r<n;r++){
            while(costNum[r] - (l>0 ? costNum[l-1] : 0) > maxCost){
                l++;
            }
            max = Math.max(max,r-l+1);

        }
        return max;
    }
}
