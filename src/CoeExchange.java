import javax.swing.*;
import java.awt.*;

public class CoeExchange extends JPanel {

    //Data Objects
    Investor i;
    Investor i2;
    Investor i3;
    Broker b;

    //GUI Objects
    StockPanel sp;
    InvestorPanel ip;
    InvestorPanel ip2;
    InvestorPanel ip3;
    BrokerPanel bp;


    public CoeExchange() {

        i = new Investor("Bob");
        i2 = new Investor("Mary");
        i3 = new Investor("Joe");

        setPreferredSize(new Dimension(450, 600));
        setBackground(new Color(255, 138, 19));

        sp = new StockPanel();
        ip = new InvestorPanel(i);
        ip2 = new InvestorPanel(i2);
        ip3 = new InvestorPanel(i3);

        b = new Broker();
        bp = new BrokerPanel(b);
        i.setBroker(b);
        i2.setBroker(b);
        i3.setBroker(b);

        add(sp);
        add(ip);
        add(ip2);
        add(ip3);
        add(bp);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Coe Exchange");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new CoeExchange();
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}