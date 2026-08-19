package random;

import java.util.HashMap;
import java.util.Map;

public class a1386 {

    // 先遍历并记录每一行的座位情况, 再对每一行的情况进行判断
    // 判断:如果2~9都是空的就可以坐两组, 如果2~5 或 4~7 或 6~9是空的就可以坐一组; (所以不用判断1和10座位)
    // 如果使用二维矩阵来存信息 + 判断的话, 比较直观, 但是丧失了每一行座位数固定 + 连续的特性
    // 可以使用一个二进制数来表示座位情况 0b00000000 = 全空

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>(); // 行数 -> 二进制数
        for (int[] nums : reservedSeats) {
            int row = nums[0];
            int seat = nums[1];
            if (2 <= seat && seat <= 9) // 只有2 ~ 9有被预定的行数才会被记录
                map.merge(row, 1 << (seat - 2), (a, b) -> (a | b)); // seat - 2将2压缩到0
        }

        // 对于没有被记录的行, 它的2~9是空的, 可以容纳2组
        int result = (n - map.size()) * 2;
        for (int x : map.values()) { // 不在意行数, 直接增强for循环取value
            if ((x & 0b1111) == 0 || (x & 0b111100) == 0 || (x & 0b11110000) == 0)
                result ++;
        }

        return result;
    }

}
