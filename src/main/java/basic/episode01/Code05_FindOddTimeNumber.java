package basic.episode01;

/**
 * offer56
 * 异或的两种解读：相同为0，不同为1；无进位相加
 * 异或的性质：a^a=0  a^0=a  异或满足交换律和结合律
 */
public class Code05_FindOddTimeNumber {
    // 数组中只有一个数字出现奇数次，其余都出现偶数次，要求找出出现奇数次的数字
    public static void findOddTimeNumber(int[] arr) {
        int eor = 0;
        // 偶数次数数字将相互抵消
        for (int num : arr) {
            eor = eor ^ num;
        }
        System.out.println(eor);
    }

    // 数组中有两个数字出现奇数次，其余都出现偶数次，要求找出出现奇数次的数字
    public static void findOddTimeNumber2(int[] arr) {
        int eor = 0;
        for (int num : arr) {
            eor = eor ^ num;
        }
        // eor=a^b
        // 由于存在两个数字出现奇数次，异或结果必然有位置不等于0
        // 找到eor中不等于0的最右边位置notZero(ex:0000000100)
        int notZero = eor & (~eor + 1);
        // 需要找出的两个数字(a,b)必然在notZero位置处一个为0，一个为1
        // 对所有notZero位置处为1的数字进行异或，可以得到两个数中的一个(a)
        int a = 0;
        for (int num : arr) {
            if ((num & notZero) == 0) a ^= num;
        }
        // a^b^a = b
        int b = eor ^ a;
        System.out.println(a + "," + b);
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        findOddTimeNumber(arr1);

        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        findOddTimeNumber2(arr2);

        System.out.println(3&(~3+1));
    }
}
