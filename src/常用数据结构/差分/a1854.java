package 常用数据结构.差分;

public class a1854 {

    public int maximumPopulation(int[][] logs) {
        int MIN = 1950, MAX = 2050;
        int[] diff = new int[MAX - MIN + 1];
        for (int i = 0; i < logs.length; i++) {
            diff[logs[i][0] - MIN] ++;
            diff[logs[i][1] - MIN] --;
        }

        int result = 0;
        for (int i = 0, c = 0, max = 0; i <= MAX - MIN; i++) {
            // c: 目前差分值
            // max : 目前最大值
            c += diff[i];
            if(c > max) {
                max = c;
                result = i + MIN;
            }
        }

        return result;
    }

}
