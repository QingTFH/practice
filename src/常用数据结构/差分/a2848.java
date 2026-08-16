package 常用数据结构.差分;

import java.util.List;

public class a2848 {

    public int numberOfPoints(List<List<Integer>> nums) {
        int MAX = 100;
        int[] diff = new int[MAX + 2];
        for (int i = 0; i < nums.size(); i++) {
            diff[nums.get(i).get(0)] ++;
            diff[nums.get(i).get(1) + 1]--;
        }

        int result = 0;
        for (int i = 0, s = 0; i < MAX + 2; i++) {
            s += diff[i];
            if(s > 0) result++;
        }

        return result;
    }

}
