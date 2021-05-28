package basic.episode03;


import java.util.Arrays;

/**
 * @Description 堆排序
 * @Date 2021/5/28 18:33
 * @Created by xiaofei
 */
public class Code01_HeapSort {
    public int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        // 建堆
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length-1);
        }

        // 排序
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i-1);
        }
        return arr;
    }

    // 堆化操作,为了兼容排序方法,heapSize不能直接取arr.length
    public void heapify(int[] arr, int index, int heapSize) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        // 当存在孩子时
        while (leftChildIndex <= heapSize) {
            // 左右孩子互相比较得到较大值
            int largeIndex = (rightChildIndex <= heapSize) && (arr[rightChildIndex] > arr[leftChildIndex]) ? rightChildIndex : leftChildIndex;
            // 和父亲节点比较得到最大值index
            largeIndex = arr[largeIndex] > arr[index] ? largeIndex : index;
            if (largeIndex == index) break;
            swap(arr, index, largeIndex);
            index = largeIndex;
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Code01_HeapSort().sort(new int[]{5,2,3,1}))
        );
    }

}
