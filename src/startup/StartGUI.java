package startup;

import gui.*;

import javax.swing.JFrame;

public class StartGUI {

	public StartGUI() {}

	public static void main(String[] args)
	{
		JFrame frame = new MenuFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
