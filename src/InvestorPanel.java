import javax.swing.*;
import java.awt.*;

public class InvestorPanel extends JPanel{

    private Investor investor;
    private JLabel nameLbl;
    private JLabel shareLbl;
    private JLabel investmentLbl;
    private JLabel profitLbl;
    private JRadioButton growthRB;
    private JRadioButton traderRB;
    private JRadioButton brokerRB;
    private JButton strategyBtn;
    private StrategyPanel strategyPanel;



    public InvestorPanel(Investor i) {
        super();
        setPreferredSize(new Dimension(400,125));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        nameLbl = new JLabel("Name:");
        shareLbl = new JLabel("Shares:");
        investmentLbl = new JLabel("Invested:");
        profitLbl = new JLabel("Profit:");
        nameLbl.setAlignmentX(LEFT_ALIGNMENT);
        shareLbl.setAlignmentX(LEFT_ALIGNMENT);
        investmentLbl.setAlignmentX(LEFT_ALIGNMENT);
        profitLbl.setAlignmentX(LEFT_ALIGNMENT);
        setInvestor(i);


        strategyPanel = new StrategyPanel(i);
        strategyPanel.setAlignmentX(LEFT_ALIGNMENT);
        add(nameLbl);
        add(shareLbl);
        add(investmentLbl);
        add(profitLbl);
        add(strategyPanel);
    }

    public void setInvestor(Investor i) {
        this.investor = i;
        nameLbl.setText("Name: "+ i.getName());
    }

    public Investor getInvestor() {
        return investor;
    }


}

