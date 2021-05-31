package demo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: zyf
 * @date: 2021/2/27 21:29
 * @description: 反射api demo
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //路径字符串获取class对象
        Class<?> clazz = Class.forName("com.zyf.demo.BasicClass");
        //构造对象
        BasicClass basicClass = (BasicClass) clazz.newInstance();
        //获取私有域并修改
        Field value = clazz.getDeclaredField("value");
        value.setAccessible(true);
        value.set(basicClass, "hello world");

        //获得所有方法并打印
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        //调用公有方法
        Method publicMethod = clazz.getDeclaredMethod("publicMethod");
        publicMethod.invoke(basicClass);
        //调用私有方法
        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(basicClass);

    }
}
