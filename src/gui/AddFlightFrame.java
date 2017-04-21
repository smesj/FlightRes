package gui;

import commands.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;

/**
 * the frame to display the fields to collect the information 
 * necessary to add a new flight to the system
 * @author Smesj
 * sam meschishnick
 * sdm438
 */
public class AddFlightFrame extends JFrame{
	
	public static final long serialVersionUID = 1;

	public AddFlightFrame() {
		setTitle("Flight Information");
		setSize(250, 350);
		setLocation(750, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		AddFlightPanel panel = new AddFlightPanel();
		add(panel);
		setVisible(true);
	}
	
	
	
			/**
			 * setup for the addflight panel
			 * contains three text fields and three labels
			 * the frame is closed with the cancel button and 
			 * information submitted with the submit button
			 * @author Smesj
			 *
			 */
			public class AddFlightPanel extends JPanel
			{
				public static final long serialVersionUID = 1;
				
				JPanel AFpanel;
				
				public AddFlightPanel()
				{
					AFpanel = new JPanel();
					AFpanel.setVisible(true);
					AFpanel.setLayout(new GridLayout(18,0));
					
					final JTextField FNfield = new JTextField(10);
					final JLabel FNlabel = new JLabel("Flight Number");
					AFpanel.add(FNlabel);
					AFpanel.add(FNfield);
					
					final JTextField WIDTHfield = new JTextField(10);
					final JLabel WDlabel = new JLabel("Flight Width");
					AFpanel.add(WDlabel);
					AFpanel.add(WIDTHfield);
					
					final JTextField CAPfield = new JTextField(10);
					final JLabel CAPlabel = new JLabel("Flight Capacity");
					AFpanel.add(CAPlabel);
					AFpanel.add(CAPfield);
					
					final JButton submit = new JButton("Submit");
					AFpanel.add(submit);
							class submitlistener implements ActionListener
							{
								public void actionPerformed(ActionEvent event)
								{
									AddFlightCommand command = new AddFlightCommand();

									int fnum = 0; 
									int fwidth = 0;
									int fcap = 0;
									
									if (isInt(FNfield.getText()) == true)
									{
										fnum = Integer.parseInt(FNfield.getText());
									}
									else
									{
										JOptionPane.showMessageDialog(getTopLevelAncestor(), 
												"Flight number Not an integer.", "error", 
												JOptionPane.ERROR_MESSAGE);
									}
									
									if (isInt(WIDTHfield.getText()) == true)
									{
										fwidth = Integer.parseInt(WIDTHfield.getText());
									}
									else
									{
										JOptionPane.showMessageDialog(getTopLevelAncestor(), 
												"Flight width Not an integer.", "error", 
												JOptionPane.ERROR_MESSAGE);
									}
									
									if (isInt(CAPfield.getText()) == true)
									{
										fcap = Integer.parseInt(CAPfield.getText());
									}
									else
									{
										JOptionPane.showMessageDialog(getTopLevelAncestor(), 
												"Flight Capacity not an integer.", "error", 
												JOptionPane.ERROR_MESSAGE);
									}
									
													
									command.addFlight(fnum, fwidth, fcap);
													
									if (command.wasSuccessful()){
										dispose();
									}
									else{
										JOptionPane.showMessageDialog(getTopLevelAncestor(), 
												"flight was not entered.", "error", 
												JOptionPane.ERROR_MESSAGE);
										FNfield.setText("");
										WIDTHfield.setText("");
										CAPfield.setText("");		
									}							
								}
							}
					submit.addActionListener(new submitlistener());
					
					final JButton cancel = new JButton("Cancel");
					AFpanel.add(cancel);
							class cancellistener implements ActionListener
							{
								public void actionPerformed(ActionEvent event)
								{
									dispose();
								}
							}
					cancel.addActionListener(new cancellistener());
					add(AFpanel, BorderLayout.WEST);
					
					
				}
				
				/**
				 * function to check if a string input is an integer
				 * @param x string entered
				 * @return true if an int false if not 
				 */
				public Boolean isInt(String x)
				{
					try {
						Integer.parseInt(x);
					}
					catch (NumberFormatException e){
						return false;
					}
					return true;
				}	
				
				
			}		
}
