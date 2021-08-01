package basic.episode09_DP;

/**
 * @author: zyf
 * @date: 2021/8/1 19:47
 * @description: 非典型动态规划
 */
public class Code05_接雨水 {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int leftMaxTemp = 0;
        for(int i =0;i<height.length;i++){
            if(height[i]>leftMaxTemp) leftMaxTemp = height[i];
            leftMax[i] = leftMaxTemp;
        }
        int[] rightMax = new int[height.length];
        int rightMaxTemp = 0;
        for(int i =height.length-1;i>=0;i--){
            if(height[i]>rightMaxTemp)rightMaxTemp = height[i];
            rightMax[i] = rightMaxTemp;
        }
        int result = 0;
        for(int i =0;i<height.length;i++){
            result +=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return result;
    }
}
