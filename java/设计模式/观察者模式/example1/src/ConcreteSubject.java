import java.util.ArrayList;
import java.util.List;

// 具体被观察者
public class ConcreteSubject implements Subject{
    private List<Observer> observerList = new ArrayList<>();
     private String state;


    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    // 通知观察者
    @Override
    public void notifyObservers() {
        for(Observer observer : observerList) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state  =state;
        notifyObservers();
    }
}
