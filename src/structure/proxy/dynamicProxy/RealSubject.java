package structure.proxy.dynamicProxy;

public class RealSubject implements Subject {

    @Override
    public void doSomething() {
        System.out.println("I am doing something");
    }

    @Override
    public void anotherthing() {
        System.out.println("there still something to do");
    }
}
