package 常用数据结构.差分;

public class a2960 {

    public int countTestedDevices(int[] batteryPercentages) {

        int result = 0;
        for (int i = 0, cost = 0; i < batteryPercentages.length; i++) {
            // cost: 已消耗电量百分比
            if(batteryPercentages[i] > cost) {
                cost++;
                result++;
            }
        }

        return result;
    }

}
