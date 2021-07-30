package basic.episode09_DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: zyf
 * @date: 2021/7/20 20:14
 * @description:
 */
public class Code04_n个骰子的点数 {
    public double[] dicesProbabilityBackTrack(int n) {
        // 回溯
        double totalCount = Math.pow(6,n);
        int[] counts = new int[n*6+1];
        backTrack(n,0,0,counts);
        ArrayList<Double> result = new ArrayList<>();
        for (int count : counts) {
            if (count != 0) result.add(count / totalCount);
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public void backTrack(int totalIndex ,int curValue, int curIndex,int[] counts){
        if(curIndex==totalIndex){
            counts[curValue]+=1;
            return;
        }
        for(int i =1;i<=6;i++){
            backTrack(totalIndex,curValue+i,curIndex+1,counts);
        }
    }

    public double[] dicesProbabilityDP(int n){

        int[][] dp = new int[n][n*6+1];
        // init
        for(int i =1;i<=6;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n*6+1;j++){
                if(dp[i][j]!=0){
                    for(int k=1;k<=6;k++){
                        dp[i+1][j+k]+=dp[i][j];
                    }
                }
            }
        }
        double total = Math.pow(6,n);
        ArrayList<Double> result = new ArrayList<>();
        for(int i=0;i<dp[n-1].length;i++){
            if(dp[n-1][i]!=0)result.add(dp[n-1][i]/total);
        }
        return result.stream().mapToDouble(Double::doubleValue).toArray();
    }
}
