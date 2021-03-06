/**
 * Observer.java
 *
 * Observers implement this interface so that
 * their update() method is called by the subject
 * when the state of the subject changes.
 */
public interface Observer {
	/**
	 * This method is called when the state of the subject
	 * changes.
	 */
	void update();
}
