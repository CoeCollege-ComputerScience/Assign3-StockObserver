import javax.swing.*;
import java.awt.*;

public class BrokerPanel extends JPanel implements StockObserver{
    private Broker b;
    private JLabel advice;

    public BrokerPanel(Broker b) {
        setPreferredSize(new Dimension(400, 40));
        this.b = b;
        advice = new JLabel();
        add(advice);
        b.addListener(this);
    }
    public Broker getBroker() {
        return b;
    }

    @Override
    public void update(StockEvent e) {
       advice.setText(e.getAdvice());
    }

}
