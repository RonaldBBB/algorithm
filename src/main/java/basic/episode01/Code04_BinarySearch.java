package basic.episode01;

public class Code04_BinarySearch {

    /**
     * 普通二分查找，结果必然存在
     */
    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            // 防止数组长度过长导致溢出
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    /**
     * 查找最左边等于target的位置
     */
    public int binarySearchEqLeft(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            // 防止数组长度过长导致溢出
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target) return mid;
                else right = mid - 1;
            } else if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    /**
     * 查找最左边大于等于target的位置
     */
    public int binarySearchGtLeft(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            // 防止数组长度过长导致溢出
            int mid = left + ((right - left) >> 1);
            if (arr[mid] >= target) {
                if (mid == 0 || arr[mid - 1] < target) return mid;
                else right = mid - 1;
            } else if (arr[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code04_BinarySearch().binarySearchEqLeft(
                new int[]{5, 7, 7, 8, 8, 10}, 8
        ));
    }
}
