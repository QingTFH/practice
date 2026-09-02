class Solution:
    def minCostClimbingStairs(self, cost: list[int]) -> int:
        # 思考: 如果我在index层台阶, 我一共花费了多少?
        #   total_cost(index) = total_cost(index - 1) + cost[index - 1]
        #   或; total_cost(index) = total_cost(index - 2) + cost[index - 2]
        #   由于要最小化total_cost(index), 因此在两者中取较小值
        # 边界情况: total_cost(0) = 0, total_cost(1) = 0(可以从1开始爬)
        # 问题: total_cost(len(cost))
        n = len(cost)
        tc0, tc1 = 0, 0
        for index in range(2, n + 1):
            tc_new = min(tc0 + cost[index - 2], tc1 + cost[index - 1])
            tc0 = tc1
            tc1 = tc_new
        return tc1
