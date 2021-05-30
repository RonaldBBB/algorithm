package demo.concurrent;


import java.util.concurrent.TimeUnit;

/**
 * @Description 验证volatile变量保证可见性
 * @Date 2021/5/28 23:17
 * @Created by xiaofei
 */
public class Code01_volatile {
    // 不使用volatile注释时threadA不会结束
    //private static boolean flag = true;
    private volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (flag){
                //注意在这里不能有输出
            };
            System.out.println("thread over");
        });
        thread.start();
        //休眠100毫秒，让线程A先执行
        TimeUnit.MILLISECONDS.sleep(100);
        //主线程设置共享变量flag等于false
        flag = false;
    }

}
