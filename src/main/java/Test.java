import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.*;

/**
 * @Description Test
 * @Date 2021/6/17 20:48
 * @Created by xiaofei
 */
public class Test {
    public int countDigitOne(int n) {
        int result = 0;
        // 数学推导题
        int high = n/10;
        int low = 0;
        int cur = n%10;
        int digit = 1;
        while(true){
            if(cur==0){
                result += high*digit;
            }else if(cur==1){
                result+=high*digit+low+1;
            }else{
                result+=(high+1)*digit;
            }
            if(high==0)break;
            low+=cur*digit;
            cur=high%10;
            high=high/10;
            digit*=10;
        }
        return result;
    }

    public static void main(String[] args) {
        new Test().countDigitOne(10);
    }
}
