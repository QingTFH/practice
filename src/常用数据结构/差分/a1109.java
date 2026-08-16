package 常用数据结构.差分;

public class a1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int min = 1, max = n;
        int[] diff = new int[max - min + 2];
        int[] result = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            diff[bookings[i][0] - min] += bookings[i][2];
            diff[bookings[i][1] - min + 1] -= bookings[i][2];
        }

        for (int i = min, c = 0; i <= max; i++) {
            c += diff[i - min];
            result[i - min] = c;
        }

        return result;
    }

}
