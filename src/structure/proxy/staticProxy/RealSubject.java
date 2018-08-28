package structure.proxy.staticProxy;

public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("deal some business...");
    }

}
