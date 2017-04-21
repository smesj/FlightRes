package gui;

import commands.*;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * The frame to display all of the passenger information in a text box
 * @author Smesj
 * sam meschishnick
 * sdm438
 */
public class DisplayPassFrame extends JFrame{
	
	public static final long serialVersionUID = 1;

	public DisplayPassFrame() {
		setTitle("Passenger Information");
		setSize(500, 500);
		setLocation(750, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DisplayPassPanel panel = new DisplayPassPanel();
		add(panel);
		setVisible(true);
	}
	
			/**
			 * setup for the displaypass panel 
			 * contains only a text box
			 * @author Smesj
			 *
			 */
			public class DisplayPassPanel extends JPanel
			{
				public static final long serialVersionUID = 1;

				JTextArea DParea;
				
				public DisplayPassPanel()
				{

					JPanel panel = new JPanel();
					
					DisplayPassengersCommand dpCMD = new DisplayPassengersCommand();
					DParea = new JTextArea(25,35);
					DParea.setText(dpCMD.getPassengersString());
					DParea.setEditable(false);
					
					JScrollPane myPane = new JScrollPane(DParea);
					myPane.setVisible(true);
					
					panel.add(myPane);
					add(panel, BorderLayout.CENTER);
					
				}
			}

}
