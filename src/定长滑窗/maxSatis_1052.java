public class maxSatis_1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int bas=0,ex=0,maxEx=0;
        int n = customers.length;
        for(int r=0;r<n;r++){
            if(grumpy[r]==0)
                bas += customers[r];
            else{
                ex += customers[r];
                maxEx = Math.max(maxEx,ex);
            }
            int l = r - minutes + 1;
            if(l>=0 && grumpy[l]==1){
                ex -= customers[l];
            }
        }

        return bas+maxEx;
    }
}
