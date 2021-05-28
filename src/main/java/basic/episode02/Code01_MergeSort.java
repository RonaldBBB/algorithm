package basic.episode02;

/**
 * @Description 归并排序 TODO: 修改binarySearch中的>>括号
 * @Date 2021/5/27 23:05
 * @Created by xiaofei
 */
public class Code01_MergeSort {

    public int[] sort(int[] arr) {
        if(arr==null||arr.length<2)return arr;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int[] mergeSort(int[] arr, int left, int right) {
        if (left == right) return arr;

        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);

        return arr;
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // 必须申请外部空间
        int[] help = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int cur = 0;
        while (l <= mid && r <= right) {
            help[cur++] = arr[l] <= arr[r] ? arr[l++] : arr[r++];
        }
        while(l<=mid){
            help[cur++]=arr[l++];
        }
        while(r<=right){
            help[cur++]=arr[r++];
        }
        for(int i=left;i<=right;i++){
            arr[i]=help[i-left];
        }
    }

}
