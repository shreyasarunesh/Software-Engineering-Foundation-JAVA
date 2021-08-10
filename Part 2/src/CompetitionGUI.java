
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CompetitionGUI  extends JFrame  implements ActionListener{
	
	JTextArea displayDetails, outputArea;
	JScrollPane scrollList;
	JTextField searchID;
	JButton searchID_B;
	
	Manager manager;
	String competetionType;


	public CompetitionGUI(String title,String competetion_type){
	    	
			manager = new Manager();
	    	manager.readFile(competetion_type);
	    	setTitle(title);
	    	competetionType = competetion_type;
	    	
			setupNorthPanel();
			setupCenterPanel();
			
			pack();
	        setVisible(true);
}

	 private void setupCenterPanel() {
	    	displayDetails = new JTextArea(25,100);
	    	displayDetails.setFont(new Font (Font.MONOSPACED, Font.PLAIN,14));
	    	displayDetails.setEditable(false);
	    	scrollList = new JScrollPane(displayDetails);
	        this.add(scrollList,BorderLayout.CENTER);
	        
	        displayDetails.setText(manager.getFullDetails(competetionType));
	        
	    }
	    
	    private void setupNorthPanel() {
	        
	    	 JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		     resultPanel.setLayout(new GridLayout(1,2));
		     resultPanel.add(outputArea = new JTextArea(2,35));
		     outputArea.setEditable(false);
		     resultPanel.add(outputArea);

	        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	        searchPanel.setLayout(new GridLayout(1,2));
	        searchPanel.add(searchID = new JTextField(10));
	        searchPanel.add(searchID_B = new JButton("Search"));
	        
	       
	        JPanel northPanel = new JPanel();
	        northPanel.add(searchPanel);
	        northPanel.add(searchID);
	        northPanel.add(resultPanel);
	        
	        this.add(northPanel, BorderLayout.NORTH);   
	        
	        
	    }
	    
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == searchID_B ) {
				System.out.println(manager.findChessPlayerNumber( Integer.parseInt(searchID.getText())));
				outputArea.setText(manager.findChessPlayerNumber( Integer.parseInt(searchID.getText())));
			}
		}
}
