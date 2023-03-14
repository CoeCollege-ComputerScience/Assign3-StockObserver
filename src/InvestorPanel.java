import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvestorPanel extends JPanel implements InvestorObserver{

    private Investor i;
    private JLabel nameLbl;
    private JLabel shareLbl;
    private JLabel investmentLbl;
    private JRadioButton growthRB;
    private JRadioButton traderRB;
    private JRadioButton brokerRB;
    private JButton strategyBtn;



    public InvestorPanel(Investor i) {
        super();
        setPreferredSize(new Dimension(400,150));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        nameLbl = new JLabel();
        shareLbl = new JLabel();
        investmentLbl = new JLabel();
        growthRB = new JRadioButton("Growth");
        traderRB = new JRadioButton("Trader");
        brokerRB = new JRadioButton("Broker");
        ButtonGroup bg = new ButtonGroup();
        bg.add(growthRB);
        bg.add(traderRB);
        bg.add(brokerRB);
        growthRB.setSelected(true);
        strategyBtn = new JButton("Set Strategy");
        i.setIs(new GrowthStrategy());

        strategyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Broker b = i.getBroker();
                b.removeListener(i);

                if (growthRB.isSelected()){
                    i.setIs(new GrowthStrategy());
                }
                if(traderRB.isSelected()){
                    i.setIs(new TraderStrategy(i.getSharesOwned(),i.getInvestedAmt()));
                }
                if(brokerRB.isSelected()){
                    b.addListener(i);
                    i.setIs(new BrokerStrategy());
                }
            }
        });
        setInvestor(i);

        add(nameLbl);
        add(shareLbl);
        add(investmentLbl);
        add(growthRB);
        add(traderRB);
        add(brokerRB);
        add(strategyBtn);

    }

    public void setInvestor(Investor i) {
        if (this.i!= null){
            this.i.removeListener(this);
        }
        this.i = i;
        nameLbl.setText("Name: "+ i.getName());
        i.addListener(this);
    }

    public Investor getInvestor() {
        return i;
    }

    @Override
    public void update() {
        String shares = Integer.toString(i.getSharesOwned());
        String investedAmt = String.format("%.2f",i.getInvestedAmt());
        shareLbl.setText("Shares: "+shares);
        investmentLbl.setText("Invested: "+ investedAmt);
    }
}

