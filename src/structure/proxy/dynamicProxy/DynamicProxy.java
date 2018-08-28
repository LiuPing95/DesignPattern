package structure.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public <T> T newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler invocationHandler) {
        return (T) Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);
    }

    /**高层模块对代理的访问会更加简单*/
    public static <T> T newInstance(Object subject) throws Exception {
        if (subject == null) {
            throw new NullPointerException();
        }
        Class<?>[] interfaces = subject.getClass().getInterfaces();
        if (interfaces.length == 0) {
            throw new Exception("must implements at least one interface");
        }
        ClassLoader classLoader = subject.getClass().getClassLoader();
        MyHandler handler = new MyHandler(subject);
        return (T) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }
}
