package structure.proxy.dynamicProxy;

/**
 * 动态代理模式：
 * 代理类不仅会代理实现的方法，还会把equals hashcode toString这个三个方法一起代理了。
 * JDK的动态代理必须是要实现接口的，CGLIB可以不用实现接口
 *
 * 所有的动态代理必须是实现接口：
 *     因为所有动态生成的代理类都是Proxy的子类，而java只能单继承。
 *     需要通过这个接口反射出对应的方法，实现InvocationHandler的时候invoke的是实现类的方法。
 * */
public class Client {

    public static void main(String[] args) throws Exception {
        Subject subject = new RealSubject();
        /*Subject s = (Subject)Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), new MyHandler(subject));
        s.doSomething();*/
        /*MyHandler handler = new MyHandler(subject);
        DynamicProxy dynamicProxy = new DynamicProxy();
        Subject proxy = dynamicProxy.newProxyInstance(subject.getClass().getClassLoader(),subject.getClass().getInterfaces(),handler);
        proxy.doSomething();*/
        Subject proxy = DynamicProxy.newInstance(subject);
        proxy.doSomething();
        proxy.anotherthing();
        /*Subject ss;
        ss = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(), RealSubject.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 这个proxy不知道做什么用
                method.invoke(subject,args);
                return null;
            }
        });
        ss.doSomething();*/
    }
}
