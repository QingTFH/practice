package 常用数据结构.差分;

public class a1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        // 如果某一时刻 车上可能的人数 > capacity, 则false
        int min = 0, max = 1000;
        int[] diff = new int[max - min + 2];
        for (int i = 0; i < trips.length; i++) {
            diff[trips[i][1]] += trips[i][0];
            diff[trips[i][2]] -= trips[i][0]; // 从to开始这些人就会下车
        }

        for (int i = min, passenger = 0; i <= max; i++) {
            passenger += diff[i];
            if(passenger > capacity) return false;
        }

        return true;
    }

}
