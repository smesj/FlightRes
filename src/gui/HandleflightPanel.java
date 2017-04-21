package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * the panel to display a text box and allow the user to enter a flight number
 * to be passed into HandleFlightFrame
 * @author Smesj
 * sam meschishnick
 * sdm438
 */
public class HandleflightPanel extends JPanel{
	
	public static final long serialVersionUID = 1;

	JPanel HFpanel;
	
	/**
	 * setup of panel with a label and text box
	 */
	public HandleflightPanel()
	{
		HFpanel = new JPanel();
		HFpanel.setVisible(false);
		
		JTextField FlightNumfield = new JTextField(10);
		JLabel FlightNumlabel = new JLabel("Flight Number");
		HFpanel.add(FlightNumlabel);
		HFpanel.add(FlightNumfield);
		
				class enterlistener implements ActionListener
				{
					public void actionPerformed(ActionEvent event)
					{
						if (isInt(FlightNumfield.getText()) == true){
							int FN = Integer.parseInt(FlightNumfield.getText());
							HandleFlightFrame HF = new HandleFlightFrame(FN);
							HF.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(getTopLevelAncestor(), 
									"Flight number Not an integer.", "error", 
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}			
		FlightNumfield.addActionListener(new enterlistener());
		add(HFpanel, BorderLayout.SOUTH);
	}
	
	/**
	 * function to show panel
	 */
	public void makeVis()
	{
		HFpanel.setVisible(true);
	}
	
	/**
	 * function to hide panel
	 */
	public void makeInvis()
	{
		HFpanel.setVisible(false);
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
