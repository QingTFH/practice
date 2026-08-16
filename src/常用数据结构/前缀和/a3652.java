package 常用数据结构.前缀和;

public class a3652 {

    // 每日利润 = strategy[i] * prices[i]; 要求总利润最大
    // 操作选择k个连续元素, 将前k/2个strategy[i]设为0,后k/2设为1
    // 如果不修改, 总利润为 strategy[i] * prices[i]的和 [0,n-1]
    // 如果修改, 假设修改数组是[i-k, i-1](长度为k), 那么总利润为
    //      [0, i-k-1] 不变
    //      [i-k, i-1] 前k/2是0, 不计入; 后k/2是1, 计入, 利润为 prices[i]的和 [i-k/2, i-1]
    //      [i, n-1]   不变

    // 用前缀和表示 prefix_sum_prices 和 prefix_sum_profit, 上式分别为:
    // prefix_sum_profit[n]
    // prefix_sum_profit[i-k] + prefix_sum_prices[i] - prefix_sum_prices[i-k/2]
    //      + prefix_sum_profit[n] - prefix_sum_profit[i]

    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] prefix_sum_prices = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix_sum_prices[i+1] = prefix_sum_prices[i] + prices[i];
        }

        long[] prefix_sum_profit = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix_sum_profit[i+1] = prefix_sum_profit[i] + (long) prices[i] * strategy[i];
        }

        long max = prefix_sum_profit[n];
        for (int i = k; i <= n; i++) {
            max = Math.max(max, prefix_sum_profit[i-k]
                    + prefix_sum_prices[i] - prefix_sum_prices[i-k/2]
                    + prefix_sum_profit[n] - prefix_sum_profit[i]);
        }
        return max;
    }

}
