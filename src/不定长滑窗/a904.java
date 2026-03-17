public class a904 {
    public int totalFruit(int[] fruits) {
        //找到最长的只含两种数字的子数组，如何记录当前子数组有哪两个数字?
        int max=1,l=0,r=1,n=fruits.length;//初始化了窗口为[0,1]的情况
        int[] doc = new int[2];
        doc[0] = fruits[0];doc[1] = fruits[0];//左端点 和 右端点
        for(;r<n;r++){
            if(fruits[r]!=doc[1] && fruits[r]!=doc[0]){//新品种，要更改左端点
                doc[1] = fruits[r];
                l = r-1;
                while(l>0 && fruits[l-1]==fruits[r-1]){
                    l--;
                }
                doc[0] = fruits[l];
            }
            max = Math.max(max,r-l+1);
            System.out.println("l="+l+" r="+r);
        }
        return max;
    }
}
