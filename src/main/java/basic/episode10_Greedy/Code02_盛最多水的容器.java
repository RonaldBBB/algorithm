package basic.episode10_Greedy;

/**
 * @author: zyf
 * @date: 2021/7/30 20:42
 * @description: leetcode11
 */
public class Code02_盛最多水的容器 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left=0,right=height.length-1;
        while(left!=right){
            if((right-left)*Math.min(height[left],height[right])>maxArea){
                maxArea = (right-left)*Math.min(height[left],height[right]);
            }
            if(height[left]>height[right])right--;
            else left++;
        }
        return maxArea;
    }
}
