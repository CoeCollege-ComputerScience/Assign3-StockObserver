import java.util.ArrayList;

public class Broker implements StockObserver, StockSource {
    private double oldPrice;
    private double currentPrice;
    private int buyStreak;
    private int sellStreak;
    private ArrayList<StockObserver> observers;

    public Broker() {
        oldPrice = 0;
        buyStreak = 0;
        sellStreak = 0;
        observers = new ArrayList<StockObserver>();
    }

    @Override
    public void update(StockEvent e) {
        String msg = StockEvent.HOLD;
        currentPrice = e.getPrice();
        if (oldPrice != 0) {
            if (currentPrice > oldPrice) {
                sellStreak += 1;
                if (buyStreak > 3) {
                    msg = StockEvent.BUY;
                } else {
                    msg = StockEvent.HOLD;
                }
                buyStreak = 0;
            } else if (currentPrice < oldPrice) {
                buyStreak += 1;
                if (sellStreak > 3) {
                    msg = StockEvent.SELL;
                } else {
                    msg = StockEvent.HOLD;
                }
                sellStreak = 0;
            }
        }
        System.out.println(oldPrice);
        oldPrice = currentPrice;
        notifyListeners(new StockEvent(currentPrice, msg));
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