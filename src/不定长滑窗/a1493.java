public class a1493 {
    public int longestSubarray(int[] nums) {
        int l=0,r=0,n=nums.length,doc=-1,max=0;
        for(;r<n;r++){
            if(nums[r]==0){
                if(doc!=-1)
                    l = doc + 1;
                doc=r;
            }
            max = Math.max(r-l+1,max);

        }
        return Math.max(max-1,0);
    }
}
