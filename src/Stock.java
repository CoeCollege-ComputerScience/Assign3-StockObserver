import java.util.ArrayList;

public class Stock implements StockSource{
    private double price;
    private ArrayList<StockObserver> observers;

    public Stock() {
        price = 0;
        observers = new ArrayList<StockObserver>();
    }
    public void setPrice(double price) {
        this.price = price;
        System.out.println("Set Price"+price);
        notifyListeners(new StockEvent(this.price));
    }

    @Override
    public void addListener(StockObserver s) {
        observers.add(s);
    }

    @Override
    public void removeListener(StockObserver s) {
        observers.remove(s);
    }

    @Override
    public void notifyListeners(StockEvent e) {
        for (StockObserver s : observers) {
            s.update(e);
        }
    }
}