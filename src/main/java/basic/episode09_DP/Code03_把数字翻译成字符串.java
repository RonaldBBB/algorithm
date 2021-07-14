package basic.episode09_DP;

import java.util.Arrays;

/**
 * @author: zyf
 * @date: 2021/7/2 12:28
 * @description: offer46
 */
public class Code03_把数字翻译成字符串 {
    public int translateNum(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int[] nums = new int[chars.length];
        for(int i =0;i<chars.length;i++){
            nums[i]=chars[i]-'0';
        }
        return translateNum(nums,nums.length);
    }

    // 以index-1结尾能够转换成多少种字符串
    public int translateNum(int[] nums,int index){
        if(index==0)return 1;
        if(index==1)return 1;

        if(nums[index-2]==1)return translateNum(nums,index-1)+translateNum(nums,index-2);
        if(nums[index-2]==2&&(nums[index-1]<6))return translateNum(nums,index-1)+translateNum(nums,index-2);
        else return translateNum(nums,index-1);
    }

    public int translateNumDP(int num){
        char[] chars = Integer.toString(num).toCharArray();
        int[] nums = new int[chars.length];
        for(int i =0;i<chars.length;i++){
            nums[i]=chars[i]-'0';
        }
        // 以nums[i-1]结尾时能够转换为多少种字符串
        int[] dp = new int[nums.length+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=nums.length;i++){
            if(nums[i-2]==1||(nums[i-2]==2&&(nums[i-1]<6))){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[nums.length];
    }
}
