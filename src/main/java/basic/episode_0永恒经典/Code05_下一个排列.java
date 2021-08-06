package basic.episode_0永恒经典;

/**
 * @author: zyf
 * @date: 2021/8/4 18:13
 * @description: leetcode31
 */
public class Code05_下一个排列 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) {
                j--;
            }
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        int start = i + 1;
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        new Code05_下一个排列().nextPermutation(new int[]{1, 3, 2});
    }
}
