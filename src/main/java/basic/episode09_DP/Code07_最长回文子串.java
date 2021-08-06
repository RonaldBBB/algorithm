package basic.episode09_DP;

/**
 * @author: zyf
 * @date: 2021/8/4 14:00
 * @description:
 */
public class Code07_最长回文子串 {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String result="";
        int maxLength = 0;
        for(int l=1;l<=s.length();l++){
            for(int i=0;i<s.length()-l;i++){
                int j = i+l-1;
                if(l==1){
                    dp[i][j]=true;
                }else if(l==2){
                    dp[i][j] = s.charAt(i)==s.charAt(j);
                }else{
                    dp[i][j] = s.charAt(i)==s.charAt(j)&&dp[i+1][j-1];
                }
                if(dp[i][j]&&j-i>maxLength){
                    maxLength = j-i;
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;
    }
}
