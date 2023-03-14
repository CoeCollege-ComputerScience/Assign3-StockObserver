import java.util.ArrayList;

public class Investor {
    private String name;
    private int sharesOwned;
    private double investedAmt;
    private Broker broker;

    public Investor(String name) {
        this.name = name;
        sharesOwned = 0;
        investedAmt = 0;
    }

    public void buyShares(int numShares, double price){
    }

    public String getName() {
        return name;
    }


    public void setBroker(Broker b){
        this.broker = b;
    }

    public Broker getBroker() {
        return broker;
    }

}