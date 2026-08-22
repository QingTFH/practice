package random;

public class a3622 {

    // 难度分1149
    // 计sum为n的数位和, mult为n的数位积, 返回n % (sum + mult) == 0

    public boolean checkDivisibility(int n) {
        int sum = 0, mult = 1, tmp = n;
        while (tmp > 0) {
            int mod = tmp % 10;
            sum += mod;
            mult *= mod;
            tmp /= 10;
        }

        return n % (sum + mult) == 0;
    }

}
