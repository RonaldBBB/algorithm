package basic.episode02;

import java.util.Arrays;

/**
 * @Description 快速排序
 * @Date 2021/5/28 10:54
 * @Created by xiaofei
 */
public class Code03_QuickSort {
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left >= right) return arr;
        // 随机选取分区位置,与最后位置进行交换
        int position = left + (int) (Math.random() * (right - left + 1));
        swap(arr, right, position);
        int[] result = partitionV2(arr, left, right);
        quickSort(arr, left, result[0] - 1);
        quickSort(arr, result[1] + 1, right);
        return arr;
    }

    private int[] partition(int[] arr, int left, int right) {
        int target = arr[right];
        // [left,less)区间内的所有数小于target
        int less = left;
        for (int i = left; i < right; i++) {
            // case1
            if (arr[i] < target) {
                swap(arr, less, i);
                less++;
            }
            // case2:i++即可
        }
        swap(arr, less, right);
        return new int[]{less, less};
    }

    // 荷兰国旗问题,将数据分为三个部分,分别小于,等于,大于target
    private int[] partitionV2(int[] arr, int left, int right) {
        int target = arr[right];
        // [left,less)区间内的所有数小于target
        int less = left;
        // (more,right]区间的所有数大于target
        int more = right;
        while(left<=more){
            // case1
            if (arr[left] < target) {
                swap(arr, less++, left++);
            }
            // case2 注意此时left的位置不能动
            else if (arr[left] > target) {
                swap(arr, more--, left);

            }
            // case3 i++即可
            else left++;
        }
        return new int[]{less, more};
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Code03_QuickSort().sort(new int[]{-4,0,7,4,9,-5,-1,0,-7,-1}))
        );
    }
}
