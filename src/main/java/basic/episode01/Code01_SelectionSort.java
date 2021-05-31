package basic.episode01;

/**
 * 选择排序
 */
public class Code01_SelectionSort {
    public int[] selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            // 找到最小值替换到arr[i]
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex =j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    private void swap(int[] arr, int l, int r) {
        arr[l] = arr[l] ^ arr[r];
        arr[r] = arr[l] ^ arr[r];
        arr[l] = arr[l] ^ arr[r];
    }

}
