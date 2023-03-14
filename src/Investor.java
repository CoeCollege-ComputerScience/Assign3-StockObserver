import java.util.ArrayList;

public class Investor implements StockObserver, InvestorSource {
    private String name;
    private int sharesOwned;
    private double investedAmt;
    private InvestmentStrategy is;
    private ArrayList<InvestorObserver> observers;
    private Broker broker;

    public Investor(String name) {
        this.name = name;
        sharesOwned = 0;
        investedAmt = 0;
        observers = new ArrayList<InvestorObserver>();
    }

    public void buyShares(int numShares, double price){
        int actualShares = numShares;
        if (sharesOwned + numShares < 0){
            actualShares = -sharesOwned;
        }
        setSharesOwned(sharesOwned + actualShares );
        setInvestedAmt(investedAmt+price * actualShares);
    }

    public void setSharesOwned(int sharesOwned) {
        this.sharesOwned = sharesOwned;
    }

    public void setInvestedAmt(double investedAmt) {
        this.investedAmt = investedAmt;
     }

    public int getSharesOwned() {
        return sharesOwned;
    }

    public double getInvestedAmt() {
        return investedAmt;
    }

    public String getName() {
        return name;
    }

    public void setIs(InvestmentStrategy is) {
        this.is = is;
    }
    public void setBroker(Broker b){this.broker = b;}

    public Broker getBroker() {
        return broker;
    }

    @Override
    public void update(StockEvent e) {
        int numShares = is.buyOrSell(e);
        buyShares(numShares, e.getPrice());
        notifyListeners();
    }

    @Override
    public void addListener(InvestorObserver i) {
        observers.add(i);
    }

    @Override
    public void removeListener(InvestorObserver i) {
        observers.remove(i);
    }

    @Override
    public void notifyListeners() {
        for(InvestorObserver i: observers){
            i.update();
        }
    }
}