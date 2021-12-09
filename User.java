import java.util.ArrayList;

public class User implements Subject {
    private ArrayList<Observer> observers;
    private String pass;

    public User() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer)observers.get(i);
            observer.update(pass);
        }
    }
    
    public void measurementsChanged() {
        notifyObservers();
    }
    
    public void setMeasurements(String pass) {
        this.pass = pass;
        measurementsChanged();
    }

    public String getPass() {
        return pass;
    }
}