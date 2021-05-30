package demo.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 验证volatile变量不保证原子性
 * @Date 2021/5/28 23:19
 * @Created by xiaofei
 */
public class Code02_volatile {
    public int num;
    public AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        Code02_volatile code02_volatile = new Code02_volatile();
        for(int i = 0;i<20;i++){
            new Thread(()->{
                for(int j=0;j<10000;j++){
                    code02_volatile.num++;
                    code02_volatile.atomicInteger.getAndIncrement();
                }
            }).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println("the num is changed to "+code02_volatile.num);
        System.out.println("the atomicInteger is changed to "+code02_volatile.atomicInteger.get());
    }
}
