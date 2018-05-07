/**
 * Subject.java
 *
 * Objects implementing this interface allow observers
 * to register with it. When this object changes state,
 * it notifies all registered observers.
 */
public interface Subject {

	/* allows an observer to register with the subject */
	void addObserver(Observer o);

	/* removes an observer */	
	void removeObserver(Observer o);

	/* notifies all registered observers when its state changes */
	void notifyObservers();
}
