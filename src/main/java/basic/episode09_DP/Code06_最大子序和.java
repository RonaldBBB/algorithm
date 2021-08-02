package basic.episode09_DP;

/**
 * @author: zyf
 * @date: 2021/8/1 23:29
 * @description:
 * dp数组意义为以i为终点的最大子序和
 */
public class Code06_最大子序和 {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int result = dp[0];
        for(int i=1;i<dp.length;i++){
            if(dp[i]>result)result = dp[i];
        }
        return result;
    }
}
