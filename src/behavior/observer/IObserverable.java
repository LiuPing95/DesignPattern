package behavior.observer;

/**
 * @author Apple
 *
 * observered interface
 */
public interface IObserverable {
	
	void addObserver(IObserver observer);
	
	void delObserver(IObserver observer);
	
	void notifyObservers(String context);

	void eat();
	
	void sleep();
}
