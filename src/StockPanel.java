import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockPanel extends JPanel {

	private Stock s;
	private JTextField fname;
	private JButton openButton;
	private JTextField line;
	private JButton readButton;
	private Scanner scan;

	public StockPanel() {
		super();
		setPreferredSize(new Dimension(450,80));
		setBackground(new Color(255, 138, 19));
		fname = new JTextField();
		fname.setColumns(25);
		fname.setText("StockPrices.txt");
		openButton = new JButton("Open");
		line = new JTextField();
		line.setColumns(25);
		readButton = new JButton("Read");
		readButton.setEnabled(false);
		ButtonListener bl = new ButtonListener();
		openButton.addActionListener(bl);
		readButton.addActionListener(bl);
		s = new Stock();

		add(fname);
		add(openButton);
		add(line);
		add(readButton);
	}

	public void addObserver(StockObserver so){
		s.addListener(so);
	}

	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String p = "";
			if (e.getSource() == openButton) {
				try {
					String filename = fname.getText();
					scan = new Scanner(new File(filename));
					readButton.setEnabled(true);
					p = scan.next();
					s.setPrice(Double.valueOf(p));

				} catch (FileNotFoundException ex) {
					System.out.println("Oops");
				}
			}
			if (e.getSource() == readButton){
				p = scan.next();

				if (scan.hasNext()){
					s.setPrice(Double.valueOf(p));
				}
				else{
					readButton.setEnabled(false);
				}
			}
			line.setText(p);
		}
	}
}
