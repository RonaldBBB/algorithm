package demo.singleton;

/**
 * @author: zyf
 * @date: 2021/3/9 14:13
 * @description: 使用枚举实现单例模式，在编译层面实现单例，不需要考虑线程安全，序列化和反射问题
 */
public enum  SingletonByEnum {
    SINGLETON("xiaofei");

    private final String name;

    public String getName(){
        return name;
    }

    private SingletonByEnum(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        final String name = SingletonByEnum.SINGLETON.getName();
        System.out.println(name);
    }

}
