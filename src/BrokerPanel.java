import javax.swing.*;
import java.awt.*;

public class BrokerPanel extends JPanel{
    private Broker b;
    private JLabel advice;

    public BrokerPanel(Broker b) {
        setPreferredSize(new Dimension(400, 40));
        this.b = b;
        advice = new JLabel();
        add(advice);
    }
    public Broker getBroker() {
        return b;
    }

}
