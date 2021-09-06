package basic.episode09_DP;

/**
 * @Description leetcode5
 * @Date 2021/8/4 0:18
 * @Created by xiaofei
 */
public class Code07_最长回文子串 {
    public String longestPalindrome(String s) {
        if(s.length()==0)return s;
        int maxLength=0;
        String result="";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int length=1;length<s.length()+1;length++){
            for(int i=0;i<s.length()-length+1;i++){
                if(length==1)dp[i][i]=true;
                else if(length==2)dp[i][i+1]=s.charAt(i)==s.charAt(i+1);
                else dp[i][i+length-1]=dp[i+1][i+length-2]
                            &&s.charAt(i)==s.charAt(i+length-1);
                if(dp[i][i+length-1]&&length>maxLength){
                    result = s.substring(i,i+length);
                    maxLength = length;
                }
            }
        }
        return result;
    }
}

