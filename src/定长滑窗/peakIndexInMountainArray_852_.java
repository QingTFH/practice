class peakIndexInMountainArray_852_ {
    public int peakIndexInMountainArray(int[] arr) {
        return erfen(arr,0,arr.length);
    }
    public int erfen(int []arr,int left,int right){
        if(left == right){
            return left;
        }
        int medium = (left + right)/2;
        if(shangpo(arr,medium)){
            return erfen(arr,medium+1,right);
        }
        else
            return erfen(arr,left,medium);
    }
    boolean shangpo(int[] arr,int i){
        if(i<arr.length-1
                && arr[i]<=arr[i+1])
            return true;
        return false;
    }
}