package 常用数据结构.差分;

public class a1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int MIN = 1, MAX = 50;
        int[] diff = new int[MAX+2];
        for(int i = 0; i < ranges.length; i++) {
            diff[ranges[i][0]] ++;
            diff[ranges[i][1] + 1] --;
        }

        for (int i = 0, c = 0; i <= right; i++) {
            c += diff[i];
            if(i >= left && c <= 0) return false;
        }

        return true;
    }

}
