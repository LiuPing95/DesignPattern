package structure.proxy.staticProxy;

// 普通代理
public class Client {

    public static void main(String[] args) {
        // 这种情况必须知道要代理的是谁
        Subject subject = new RealSubject();
        new Proxy(subject).request();
    }
}
