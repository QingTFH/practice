package 常用数据结构.栈;

import java.util.ArrayList;
import java.util.List;

public class a1441 {

    public List<String> buildArray(int[] target, int n) {
        String pop = "Pop";
        String push = "Push";

        // target严格递增
        // 对于整数流中需要的数字,我们进行"Push"
        // 对于整数流中不需要的数字, 我们进行"Push + Pop"

        List<String> result = new ArrayList<>();
        for (int i = 0, j = 1; i < target.length && j <= n; i++) {
            // i是target的下标, j是整数流的元素值
            while(j != target[i]) {
                result.add(push);
                result.add(pop);
                j++;
            }
            result.add(push);
            j++;
        }

        return result;
    }

}
