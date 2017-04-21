package gui;

import commands.*;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * The frame to display all of the flight information in a text box
 * @author Smesj
 * sam meschishnick
 * sdm438
 */
public class DisplayFlightFrame extends JFrame{
	
	public static final long serialVersionUID = 1;

	public DisplayFlightFrame() {
		setTitle("Flight Information");
		setSize(500, 500);
		setLocation(750, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DisplayFlightPanel panel = new DisplayFlightPanel();
		add(panel);
		setVisible(true);
	}
	
			/**
			 * setup for the displayflight panel
			 * contains only a text box
			 * @author Smesj
			 *
			 */
			public class DisplayFlightPanel extends JPanel
			{
				public static final long serialVersionUID = 1;
				
				
				JTextArea DParea;
				
				public DisplayFlightPanel()
				{
					
					JPanel panel = new JPanel();
					
					DisplayFlightsCommand dfCMD = new DisplayFlightsCommand();
					DParea = new JTextArea(25,35);
					DParea.setText(dfCMD.getFlightsString());
					DParea.setEditable(false);
					
					JScrollPane myPane = new JScrollPane(DParea);
					myPane.setVisible(true);
					
					panel.add(myPane);
					add(panel, BorderLayout.CENTER);
					
				}
			}

}
