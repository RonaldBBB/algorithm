import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: zyf
 * @date: 2021/7/19 20:01
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k=2;
        int end = n;
        ArrayList<Integer> list = new ArrayList<>();
        while(k<end){
            if(n==k) {
                list.add(k);
                break;
            }
            while(n%k==0){
                list.add(k);
                n/=k;
            }
            k++;
        }
        System.out.print(end+"=");
        for (int i = 0; i <list.size()-1; i++) {
            System.out.print(list.get(i));
            System.out.print("*");
        }
        System.out.print(list.get(list.size()-1));
    }
}
