package structure.proxy.dynamicProxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    private Object target;

    public MyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        File file = new File("./"+proxy.getClass().getSimpleName()+".class");
        if (!file.exists()) {
            System.out.println("start generate proxy .class file");
            byte[] bytes = ProxyGenerator.generateProxyClass(proxy.getClass().getSimpleName(), proxy.getClass().getInterfaces());
            FileOutputStream out = new FileOutputStream("./"+proxy.getClass().getSimpleName()+".class");
            out.write(bytes);
            out.flush();
            out.close();
            System.out.println("generate proxy .class file completed");
        } else {
            System.out.println(file.getAbsolutePath());
        }
        System.out.println("proxy start deal...");
        Object result = method.invoke(target, args);
        System.out.println("proxy deal completed...");
        return result;
    }
}
