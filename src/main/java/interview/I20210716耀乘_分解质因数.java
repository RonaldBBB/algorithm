package interview;

import java.util.ArrayList;

/**
 * @author: zyf
 * @date: 2021/7/16 20:34
 * @description:
 */
public class I20210716耀乘_分解质因数 {
    public ArrayList<ArrayList<Integer>> factorization(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int k=2;
        while (k <= n) {
            if (k == n) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(k);
                temp.add(1);
                result.add(temp);
                break;
            } else if (n % k == 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(k);
                temp.add(0);
                while (n % k == 0) {
                    temp.set(1, temp.get(1) + 1);
                    n /= k;
                }
                result.add(temp);
            } else if (n % k != 0) {
                k++;
            }
        }
        return result;
    }

}
