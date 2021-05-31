package basic.episode01;

/**
 * 冒泡排序
 */
public class Code02_BubbleSort {

    public int[] BubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        // 每次冒泡可以确定最后一位的数据
        for (int end = arr.length - 1; end > 0; end--) {
            // 在[0,end]范围内冒泡
            for (int j = 0; j < end; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    private void swap(int[] arr, int l, int r) {
        arr[l] = arr[l] ^ arr[r];
        arr[r] = arr[l] ^ arr[r];
        arr[l] = arr[l] ^ arr[r];
    }
}
