package behavior.observer;

public class Observer implements IObserver {

	@Override
	public void getStatus(String status) {
		System.out.println(status);
	}
	
}
