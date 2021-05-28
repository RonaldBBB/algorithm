package basic.episode02;

/**
 * @Description 逆序对个数:归并排序扩展(剑指offer.51)
 * @Date 2021/5/27 23:31
 * @Created by xiaofei
 */
public class Code02_逆序对个数 {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        return reversePairs(nums, 0, nums.length - 1);
    }

    private int reversePairs(int[] nums, int left, int right) {
        if (left == right) return 0;
        int mid = left + ((right - left) >> 1);
        return reversePairs(nums, left, mid) + reversePairs(nums, mid + 1, right) + merge(nums, left, mid, right);
    }

    // 定义变量count,每次merge时如果插入的是右边一半的数字,将count加上此时左边剩余数字的个数
    private int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int[] help = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int cur = 0;
        while (l <= mid && r <= right) {
            if (nums[l] > nums[r]) count += mid - l + 1;
            help[cur++] = nums[l] <= nums[r] ? nums[l++] : nums[r++];
        }
        while (l <= mid) {
            help[cur++] = nums[l++];
        }
        while (r <= right) {
            help[cur++] = nums[r++];
        }
        for (int i = left; i <= right; i++) {
            nums[i] = help[i - left];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(
                new Code02_逆序对个数().reversePairs(new int[]{7, 5, 6, 4})
        );
    }
}
