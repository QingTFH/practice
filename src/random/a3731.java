package random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class a3731 {

    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int max = nums[0], min = nums[0];
        HashMap<Integer, Integer> map = new HashMap<>(); // 数值 -> 频率
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            map.merge(nums[i], 1, Integer::sum);
        }

        for(int i = min; i <= max; i++) {
            if(!map.containsKey(i)) {
                result.add(i);
            }
        }

        return result;
    }

}
