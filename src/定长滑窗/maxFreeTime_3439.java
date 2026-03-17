public class maxFreeTime_3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        //移动k个会议 = 将k+1个空闲时间拼接
        //题意转化为 连续的k+1个空闲时间的最大值
        int n = startTime.length;
        int[] space = new int[n+1];//有n个会议，一共有n+1个空闲块
        int max=0;
        space[0] = startTime[0];
        space[n] = eventTime - endTime[n-1];
        for(int i=1;i<n;i++){
            space[i]=startTime[i]-endTime[i-1];
        }
        //对space数组进行长度k的定长滑动窗口最大值计算
        return maxDingChang_HuaChuang(space,k+1);
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
