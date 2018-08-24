package Observer;

import java.util.ArrayList;
import java.util.List;

public class Observerable implements IObserverable {

	private List<IObserver> observers = new ArrayList<>();
	
	@Override
	public void eat() {
		System.out.println("start eatting");
		notifyObservers("is sleeping");
	}

	@Override
	public void sleep() {
		System.out.println("start sleeping");
		notifyObservers("is sleeping");
	}

	@Override
	public void addObserver(IObserver observer) {
		observers.add(observer);
	}

	@Override
	public void delObserver(IObserver observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String context) {
		for (IObserver observer : observers) {
			observer.getStatus(context);
		}
	}
	
}
