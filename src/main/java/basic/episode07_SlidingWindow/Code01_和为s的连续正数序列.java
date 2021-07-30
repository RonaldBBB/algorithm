package basic.episode07_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: zyf
 * @date: 2021/7/17 16:06
 * @description:
 * offer57
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Code01_和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        // 滑动窗口思路
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int sum=0;
        int right = 0;
        for(int left=0;left<target/2+1;left++){
            if(left!=0)sum-=left;
            while(sum<target){
                sum+=right+1;
                right++;
            }
            if(sum==target){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = left+1;i<=right;i++){
                    temp.add(i);
                }
                result.add(temp);
            }
        }

        int[][] resultArrs = new int[result.size()][];
        for(int i=0;i<result.size();i++){
            resultArrs[i] = result.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return resultArrs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Code01_和为s的连续正数序列().findContinuousSequence(15)));
    }
}
