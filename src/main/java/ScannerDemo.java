import java.util.Scanner;

/**
 * @author: zyf
 * @date: 2021/7/16 19:25
 * @description:
 */
public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(a+b);
        }
    }
}
