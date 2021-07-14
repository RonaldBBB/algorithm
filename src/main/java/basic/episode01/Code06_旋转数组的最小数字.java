package basic.episode01;

/**
 * @author: zyf
 * @date: 2021/6/20 17:18
 * @description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */
public class Code06_旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        if (numbers.length == 1) return numbers[0];
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 此时右边一定有序，mid可能是最小值,所以不能right=mid-1
            if(numbers[mid]<numbers[right])right = mid;
            // 此时左边一定有序，mid不可能是最小值
            else if(numbers[mid]>numbers[right])left = mid+1;
            // 由于left==right时会right--，所以一定能跳出循环
            else right--;
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        System.out.println(new Code06_旋转数组的最小数字().minArray(new int[]{2, 2, 2, 0, 1}));
    }
}
