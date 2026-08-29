package 链表_二叉树_回溯.回溯;

public class lcp51 {

    // 所有情况就是: 对于料理i选择做与不做
    int[][] cb, ats;
    int[] mat;
    int limit;
    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {
        cb = cookbooks;
        ats = attribute;
        mat = materials;
        this.limit = limit;
        return dfs(0, 0, 0);
    }

    private int dfs(int index, int sum, int at) {
        // 对于第index道菜, 有两种情况: 做 or 不做, 选出其中合法并且最优的值
        if (index == cb.length)     // 边界情况
            return sum >= limit ? at : -1;

        int r = dfs(index + 1, sum, at);    // 不做

        boolean flag = true;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i] < cb[index][i]) {
                flag = false;
                break;
            }
        }

        if (flag) {      // 另一种情况合法
            for (int i = 0; i < mat.length; i++) {  // 布置现场
                mat[i] -= cb[index][i];
            }
            r = Math.max(dfs(index + 1, sum + ats[index][1], at + ats[index][0]), r);   // 选出最优解
            for (int i = 0; i < mat.length; i++) {  // 恢复现场
                mat[i] += cb[index][i];
            }
        }

        return r;
    }

}
