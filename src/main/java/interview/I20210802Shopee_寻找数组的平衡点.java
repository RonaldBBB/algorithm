package interview;

/**
 * @author: zyf
 * @date: 2021/8/2 19:22
 * @description: 寻找数组的平衡点 （低配接雨水）
 * 给出一个数组，你需要找到在这个数组中的“平衡点”。
 * 一个数组的“平衡点”满足 在它左边的所有数字的和等于在它右边的所有数字的和（不包括平衡点本身）。
 * 你的代码应该返回平衡数的下标，如果平衡数存在多个，返回最小的下标。
 * 1. 保证存在一个可行解
 * 2. 3 <= length(inputArray) <= 10^5
 * 3. 1 <= inputArray[i] <= 2*10^4, where 0 <= i < length(inputArray)
 */
public class I20210802Shopee_寻找数组的平衡点 {
    public int findBalancedIndex(int[] inputArray) {
        int[] leftSum = new int[inputArray.length];
        leftSum[0] = 0;
        for (int i = 1; i < inputArray.length; i++) {
            leftSum[i] = leftSum[i - 1] + inputArray[i - 1];
        }
        int[] rightSum = new int[inputArray.length];
        rightSum[inputArray.length - 1] = 0;
        for (int i = inputArray.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + inputArray[i + 1];
        }

        for (int i = 1; i < inputArray.length - 1; i++) {
            if (leftSum[i] == rightSum[i]) return i;
        }
        return -1;
    }
}
