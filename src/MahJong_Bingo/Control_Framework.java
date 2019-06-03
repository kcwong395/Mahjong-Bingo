package MahJong_Bingo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Control_Framework extends JFrame {
	
	// initialize panel
	public static Control_Framework main_frame;
	static start_page start_Page = new start_page();
	static drawing_page drawing_Page = new drawing_page();
	static gaming_page gaming_Page = new gaming_page();
	public static Stitch girl;
	public static Stitch boy;
	public static JLabel girldialog;
	public static JLabel boydialog;
	// end framework initialization
	
	// constructor
	public Control_Framework() { 
		// framework properties
		setTitle("Mahjong Bingo!");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set close button
		setBounds(0, 0, 1200, 700); // set window size
		setLocationRelativeTo(null);
		setResizable(false);
		// end framework properties
		
		RenewPanel(); // initialize pages
		switchPage(1); // goto start page

	}
	
	// control the showing page
	public static void switchPage(int desired_page) {
		switch (desired_page) {
			case(1): // goto start page
				start_Page.setVisible(true);
				drawing_Page.setVisible(false);
				gaming_Page.setVisible(false);
				girl.setVisible(false);
				boy.setVisible(false);
				break;
				
			case(2): // goto drawing page
				start_Page.setVisible(false);
				drawing_Page.setVisible(true);
				gaming_Page.setVisible(false);
				girl.setVisible(true);
				boy.setVisible(true);
				break;
				
			case(3): // goto gaming page
				start_Page.setVisible(false);
				drawing_Page.setVisible(false);
				gaming_Page.setVisible(true);
				gaming_Page.putMJ();
				girl.setVisible(true);
				boy.setVisible(true);
				break;
		}
	}
	
	public void RenewPanel(){
		// remove old pages
		remove(start_Page);
		remove(drawing_Page);
		remove(gaming_Page);
		// end of removal
		
		// initialize the pages
		start_Page = new start_page();
		drawing_Page = new drawing_page();
		gaming_Page = new gaming_page();
		start_Page.setLocation(0, 0);
		start_Page.setBorder(new EmptyBorder(5, 5, 5, 5));
		start_Page.setLayout(null);
		getContentPane().add(start_Page);
		getContentPane().add(drawing_Page);
		getContentPane().add(gaming_Page);
	}
	
	// main function to run the program
	public static void main(String[] args) {
		main_frame = new Control_Framework();
		main_frame.setVisible(true);
	}
}