public class _banzi {
    public int boolToInt(boolean a){
        return a ? 1:0;
    }
    public boolean isVowel(char a){
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
}
