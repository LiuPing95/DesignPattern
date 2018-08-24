package Observer;

public class Client {

	public static void main(String[] args) {
		// 创建一个被观察者
		IObserverable observerable = new Observerable();
		// 添加两个观察者
		observerable.addObserver(new Observer());
		observerable.addObserver(new Observer());
		// 当被观察者发生变化，观察者得到消息
		observerable.eat();
		observerable.sleep();
	}
}
