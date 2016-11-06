package BlackJack.model;

import BlackJack.controller.IVisitor;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
	public void accept(IVisitor visitor);
}
