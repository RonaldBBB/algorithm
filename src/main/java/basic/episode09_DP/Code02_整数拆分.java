package basic.episode09_DP;

/**
 * @author: zyf
 * @date: 2021/6/21 10:51
 * @description:
 * leetcode343 offer14
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。返回你可以获得的最大乘积。
 */
public class Code02_整数拆分 {
    public int cuttingRope(int n){
        // base case
        if(n==1)return 1;
        // n-1种可能中的最大值
        int result = 0;
        for(int i=1;i<n;i++){
            int max =Math.max(i*(n-i),i*cuttingRope(n-i));
            result = Math.max(result,max);
        }
        return result;
    }

    public int cuttingRopeDP(int n){
        int[] dp = new int[n+1];
        dp[1]=1;
        for(int i =2;i<=n;i++){
            int result = 0;
            for(int j=1;j<i;j++){
                int max = Math.max(j*(i-j),j*dp[i-j]);
                result = Math.max(result,max);
            }
            dp[i]=result;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new Code02_整数拆分().cuttingRopeDP(10));
    }

}
