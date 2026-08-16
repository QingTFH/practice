public class maxScore_1423 {
    public int maxScore(int[] cardPoints, int k) {
        int min = Integer.MAX_VALUE;
        int sumAll = 0;
        int sum=0;
        int n = cardPoints.length;
        int tmp = n-k;
        if(tmp==0){
            for(int r=0;r<n;r++){
                sumAll+=cardPoints[r];
            }
            return sumAll;
        }
        for(int r=0;r<n;r++){
            sumAll += cardPoints[r];
            sum += cardPoints[r];
            int l = r-tmp+1;

            if(l<0){
                continue;
            }
            min = Math.min(min,sum);
            sum -= cardPoints[l];

        }
        return sumAll-min;
    }
}
