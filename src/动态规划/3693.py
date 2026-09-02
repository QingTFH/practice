class Solution:
    def climbStairs(self, n: int, costs: list[int]) -> int:
        # 类似746: 思考：假设我站在第index级台阶，到达我这里的最小“总成本”是多少
        # total_cost[index] = min(total_cost[index - diff] + diff**2) + costs[index - 1], 1 <= diff <= 3
        # 边界情况: total_cost[0] = 0
        # 补充: costs[i] -> 第i+1级台阶的cost
        total_cost = [0] * (n + 1)
        for index in range(1, n + 1):
            start = max(0, index - 3)
            total_cost[index] = (
                min((total_cost[pre] + (index - pre) * (index - pre)) for pre in range(start, index))
                + (costs[index - 1])
            )
        return total_cost[n]
