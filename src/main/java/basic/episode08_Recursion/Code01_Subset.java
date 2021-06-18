package basic.episode08_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * leetcode78
 * 给你一个整数数组 nums ，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
 * 解集不能包含重复的子集。你可以按任意顺序返回解集。
 *
 * 和求字符串所有子序列思路相同
 * @Date 2021/6/17 20:41
 * @Created by xiaofei
 */
public class Code01_Subset {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums,0,new ArrayList<>());
        return result;
    }

    /**
     * @param nums nums始终不变
     * @param index 当前所在位置
     * @param before 之前的选择
     */
    private void subsets(int[] nums, int index, List<Integer> before) {
        if(index == nums.length){
            // 注意需要复制
            result.add(new ArrayList<>(before));
            return;
        }

        // 选择当前元素
        before.add(nums[index]);
        subsets(nums,index+1,before);
        before.remove(before.size()-1);

        // 不选择当前元素
        subsets(nums,index+1,before);

    }
}
