package demo.singleton;

/**
 * @author: zyf
 * @date: 2021/3/9 14:04
 * @description: 使用Synchronized实现双重检验锁单例模式
 */
public class SingletonBySynchronized {

    private volatile static SingletonBySynchronized singleton;

    private SingletonBySynchronized() {

    }

    public static SingletonBySynchronized getSingleton(){
        if(singleton==null){
            synchronized(SingletonBySynchronized.class){
                if(singleton==null){
                    singleton = new SingletonBySynchronized();
                }
            }
        }
        return singleton;
    }
}
