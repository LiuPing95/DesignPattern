package structure.proxy.staticProxy;

/**
 * 本来应该在目标类中执行的方法，放到了代理类中执行。
 * 如果是强制代理，那么只能通过代理来访问。
 * */
public class Proxy implements Subject {

    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("proxy start deal request");
        before();
        subject.request();
        after();
    }

    /**在代理里面，可以扩展其他的操作*/
    private void before() {
        System.out.println("before deal request");
    }

    private void after() {
        System.out.println("after deal request");
    }
}
