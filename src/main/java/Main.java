import java.awt.image.PixelInterleavedSampleModel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: zyf
 * @date: 2021/7/19 20:01
 * @description:
 */
public class Main {
    public int mySqrt(int x) {
        if (x == 1) return 1;
        for (int i = 46340; i <= x; i++) {
            if (i * i == x) return i;
            else if(i*i>x) return i-1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Main().mySqrt(2147395600));
    }
}
