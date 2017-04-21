package gui;


import java.awt.BorderLayout;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * the frame to display the main menu of the program
 * the buttons access all of the program functions
 * add flight
 * add passenger
 * display flight
 * display passenger
 * handle flight
 * quit
 * 
 * @author Smesj
 * sam meschishnick
 * sdm438
 *
 */
public class MenuFrame extends JFrame{
	
	public static final long serialVersionUID = 1;

	HandleflightPanel HFpanel;
	
	/**
	 * Setting up frame to contain main menu
	 */
	public MenuFrame() {
		createComponents();
		setSize(1000, 150);
		setLocation(400, 0);
	}
	
	/**
	 * addflight button with click listener
	 */
	private JButton addflight;
			class AFlistener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{			
					HFpanel.makeInvis();
					new AddFlightFrame();
				}
			}
	
	/**
	 * new passenger button with click listener
	 */
	private JButton newpass;
			class NPlistener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{		
					HFpanel.makeInvis();
					new AddPassengerFrame();
				}
			}
	
	/**
	 * display flight information button with click listener
	 */
	private JButton dispflight;
			class DFlistener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{		
					HFpanel.makeInvis();
					new DisplayFlightFrame();
				}
			}
	
	/**
	 * display passenger information button with listener
	 */
	private JButton disppass;
			class DPlistener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{	
					HFpanel.makeInvis();
					new DisplayPassFrame();
				}
			}
						
		
	/**
	 * handle flight button with click listener
	 */
	private JButton handleflight;
			class HFlistener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{	
					HFpanel.makeVis();				
				}
			}
			
	/**
	 * quit button with click listener
	 */
	private JButton quit;
			class Qlistener implements ActionListener
			{
				public void actionPerformed(ActionEvent event)
				{					
					System.exit(0);
				}
			}
	
	/**
	 * function to setup main menu frame and buttons
	 */
	protected void createComponents()
	{
		addflight = new JButton("Add Flight");		
		addflight.addActionListener(new AFlistener());
		
		newpass = new JButton("Add Passenger");
		newpass.addActionListener(new NPlistener());
		
		dispflight = new JButton("Display Flight");
		dispflight.addActionListener(new DFlistener());
		
		disppass = new JButton("Display Passenger");
		disppass.addActionListener(new DPlistener());
		
		handleflight = new JButton("Handle Flight");
		handleflight.addActionListener(new HFlistener());
				
		quit = new JButton("Quit");
		quit.addActionListener(new Qlistener());
		
		JPanel menupanel = new JPanel();
		menupanel.add(addflight);
		menupanel.add(newpass);
		menupanel.add(dispflight);
		menupanel.add(disppass);
		menupanel.add(handleflight);
		menupanel.add(quit);
		HFpanel = new HandleflightPanel();

		add(menupanel, BorderLayout.NORTH);
		add(HFpanel, BorderLayout.SOUTH);
	}

}
