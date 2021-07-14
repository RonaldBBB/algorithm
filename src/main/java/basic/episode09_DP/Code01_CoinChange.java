package basic.episode09_DP;

import java.util.Arrays;

/**
 * @author: zyf
 * @date: 2021/6/20 10:22
 * @description: leetcode322
 * 给定不同面额的硬币coins和一个总金额amount.编写一个函数来计算可以凑成总金额所需的最少的硬币个数.如果没有任何一种硬币组合能组成总金额,返回-1
 * 你可以认为每种硬币的数量是无限的.
 */
public class Code01_CoinChange {
    public int coinChange(int[] coins, int amount) {
        //return f(coins, amount);

        //int[] dp = new int[amount + 1];
        //return f2(coins, amount, dp);

        return f3(coins,amount);
    }

    // 暴力递归
    private int f(int[] coins, int rest) {
        if (rest == 0) return 0;
        if (rest < 0) return -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int cur = f(coins, rest - coins[i]);
            if (cur != -1 && cur < result) result = cur;
        }
        return result == Integer.MAX_VALUE ? -1 : result + 1;
    }

    // 记忆化搜索
    // 0表示没有经过计算 -1表示经过计算不可行 rest==0时为base case
    private int f2(int[] coins, int rest, int dp[]) {
        if (rest == 0) return 0;
        if (dp[rest] != 0) return dp[rest];

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (rest - coins[i] >= 0) {
                int cur;
                if (dp[rest - coins[i]] != 0) cur = dp[rest - coins[i]];
                else cur = f2(coins, rest - coins[i], dp);
                dp[rest - coins[i]] = cur;
                if (cur != -1 && cur < result) result = cur;
            }
        }
        if (result != Integer.MAX_VALUE) {
            dp[rest] = result + 1;
            return result + 1;
        } else return -1;

    }

    // 动态规划
    private int f3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) min = Math.min(min, dp[i - coins[j]]);
            }
            if (min != Integer.MAX_VALUE) dp[i] = min + 1;
            else dp[i] = -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Code01_CoinChange().coinChange(new int[]{1, 2, 5}, 11));
    }

}
