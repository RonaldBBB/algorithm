package basic.episode_0永恒经典;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 三数之和 排序+双指针 时间复杂度位O(n²)
 * @Date 2021/7/30 23:52
 * @Created by xiaofei
 */
public class Code04_三数之和 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if(nums.length<3)return new ArrayList<>();
        for(int first = 0;first<nums.length-2;first++){
            if(first>0&&nums[first]==nums[first-1])continue;
            int second = first+1;
            int third = nums.length-1;
            while(second<third){
                if(nums[first]+nums[second]+nums[third]==0){
                    result.add(Arrays.asList(nums[first],nums[second],nums[third]));
                    while(second+1<third&&nums[second+1]==nums[second])second++;
                    second++;
                }
                else if(nums[second]+nums[third]>-nums[first])third--;
                else{
                    while(second+1<third&&nums[second+1]==nums[second])second++;
                    second++;
                }
            }
        }
        return result;
    }
}
