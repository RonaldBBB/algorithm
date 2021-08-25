import java.util.Scanner;

public class Main {

    public static int[] function(int n,int a1,int b1,int a2,int b2){
        int[] resultArr = new int[2];
        double result = 0;
        for(int i=0;i<=n;i++){
            double temp = Math.sqrt(Math.pow((i*a1+(n-i)*a2),2)+
                    Math.pow((i*b1+(n-i)*b2),2));
            if(temp>result){
                resultArr[0]=i;
                resultArr[1]=n-i;
                result = temp;
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int a1 = sc.nextInt();
        int b1 = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int[] result = function(n,a1,b1,a2,b2);
        System.out.println(result[0]+" "+result[1]);
    }
}
