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
 * necessary to add a new passenger to the system
 * @author Smesj
 * sam meschishnick
 * sdm438
 */
public class AddPassengerFrame extends JFrame{

	public static final long serialVersionUID = 1;
	
	public AddPassengerFrame() {
		setTitle("Passenger Information");
		setSize(250, 350);
		setLocation(750, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		AddPassengerPanel panel = new AddPassengerPanel();
		add(panel);
		setVisible(true);
	}
	
			/**
			 * setup for the addpassenger panel
			 * contains two text fields and two labels
			 * the frame is closed with the button and information submitted with
			 * the enter key
			 * @author Smesj
			 *
			 */
			public class AddPassengerPanel extends JPanel
			{
				public static final long serialVersionUID = 1;
				
				JPanel APpanel;
				
				public AddPassengerPanel()
				{
					APpanel = new JPanel();
					APpanel.setVisible(true);
					APpanel.setLayout(new GridLayout(18,0));
															
					final JTextField NMfield = new JTextField(10);					
					final JLabel NMlabel = new JLabel("Passenger Name");
					APpanel.add(NMlabel);
					APpanel.add(NMfield);
										
					final JTextField PNfield = new JTextField(10);
					final JLabel PNlabel = new JLabel("Phone Number");
					APpanel.add(PNlabel);
					APpanel.add(PNfield);
					
							class enterlistener implements ActionListener
							{
								public void actionPerformed(ActionEvent event)
								{
									AddPassengerCommand command = new AddPassengerCommand();
									String name = NMfield.getText();
									String number = PNfield.getText();
									command.addPassenger(name, number);
									
									if (command.wasSuccessful() == false)
									{
										JOptionPane.showMessageDialog(getTopLevelAncestor(), 
												command.getErrorMessage(), "error", 
												JOptionPane.ERROR_MESSAGE);
									}
									
									NMfield.setText("");
									PNfield.setText("");
								}
							}
							
					NMfield.addActionListener(new enterlistener());
					PNfield.addActionListener(new enterlistener());

					
					final JButton close = new JButton("Close");
					APpanel.add(close);
							class cancellistener implements ActionListener
							{
								public void actionPerformed(ActionEvent event)
								{
									dispose();
								}
							}
					close.addActionListener(new cancellistener());
					add(APpanel, BorderLayout.WEST);
				}
			}

}
