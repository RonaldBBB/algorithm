package interview;

/**
 * @author: zyf
 * @date: 2021/8/2 19:42
 * @description: 数的划分
 * https://blog.csdn.net/elma_tww/article/details/86538836
 * 将整数n分成k份，且每份不能为空，任意两种分法不能相同(不考虑顺序)。
 * 例如: n = 7, k = 3, 下面三种分法被认为是相同的：
 * 1, 1, 5; 1, 5, 1; 5, 1, 1。
 * 问有多少种不同的分法。
 * 输入: n, k (6 < n < 200, 1 < k < 7)
 * 输出: 一个整数 (所有可能的分法总数)
 */
public class I20210802Shopee_数的划分 {
    public int divide(int n, int k) {
        int dp[][] = new int[201][7];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) dp[i][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i >= j) {
                    dp[i][j] = dp[i - j][j] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][k];
    }


    int count = 0;

    public int divideDFS(int n, int k) {
        dfs(0, 0, 1, n, k);
        return count;
    }

    // m指的是当前值 下一个值必须大于等于当前值m
    public void dfs(int step, int sum, int m, int n, int k) {
        if (step == k) {
            if (sum == n) {
                count++;
            }
        } else {
            for (int i = m; i <= n - m; i++) {
                dfs(step + 1, sum + i, i, n, k);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new I20210802Shopee_数的划分().divide(7, 7));
    }
}
