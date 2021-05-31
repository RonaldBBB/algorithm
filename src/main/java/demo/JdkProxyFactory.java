package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: zyf
 * @date: 2021/3/5 20:25
 * @description: jdk中的动态代理demo
 */
public class JdkProxyFactory {

    public static class MyInvocationHandler implements InvocationHandler {
        private final Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before method " + method.getName());
            Object result = method.invoke(target, args);
            System.out.println("after method " + method.getName());
            return result;
        }
    }

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new MyInvocationHandler(target));
    }

    public static void main(String[] args) {
        BasicInterface basicInterface = (BasicInterface) JdkProxyFactory.getProxy(new BasicClass());
        basicInterface.publicMethod();
    }


}
