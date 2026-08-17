package 常用数据结构.字典树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class a3597 {

    // 感觉可以直接HashSet? hash的contains/get复杂度应该狠低

    // set的contains(string), 时间复杂度为O(string.length), 还是比较大的
    // 题解使用字典树, 可以消除掉contains方法的花费
    //      (遍历一个char c时, 直接取children数组的值是O(1)的时间, 只要不存在这条路就意味着没有这个字符串)

    public List<String> partitionString(String s) {
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if(!set.contains(sb.toString())) {
                set.add(sb.toString());
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return result;
    }

}
