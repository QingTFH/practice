package 常用数据结构.枚举技巧.枚举右维护左;

import java.util.Arrays;
import java.util.HashMap;

public class a3805 {

    public long countPairs(String[] words) {
        long result = 0;

        HashMap<String, Integer> map = new HashMap<>(); // 以a开头的字符串 -> 频率
        for (int i = 0; i < words.length; i++) {
            String temp = decrypt(words[i]);
            result += map.getOrDefault(temp, 0);
            map.merge(temp, 1, Integer::sum);
        }

        return result;
    }

    public String decrypt(String origin) {
        char[] temp = origin.toCharArray();
        int gap = temp[0] - 'a';
        for(int i = 0; i < temp.length; i++) {
            temp[i] = (char) ((temp[i] + 26 - gap) % 26);
        }
        return Arrays.toString(temp);
    }
    

}
