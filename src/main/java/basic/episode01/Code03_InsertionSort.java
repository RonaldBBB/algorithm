package basic.episode01;

/**
 * 插入排序
 * 优势在于：数据的内容会影响执行的效率，比如在数据已经排序的情况下复杂度是 n
 */
public class Code03_InsertionSort {

    public int[] insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        //[0,i-1]范围内的数据已经排序,使[0,i]范围内的数据有序
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
        return arr;
    }

    private void swap(int[] arr, int L, int R) {
        int temp = arr[L];
        arr[L] = arr[R];
        arr[R] = temp;
    }
}
