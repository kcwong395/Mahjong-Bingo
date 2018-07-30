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
	static start_page start_Page = new start_page();
	static drawing_page drawing_Page = new drawing_page();
	static gaming_page gaming_Page = new gaming_page();
	public static boolean callfromlisten = false;
	public static Control_Framework main_frame;
	// framework initialization
	public Control_Framework() {
		setTitle("Mahjong Bingo!");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		start_Page.setLocation(0, 0);
		start_Page.setBorder(new EmptyBorder(5, 5, 5, 5));
		start_Page.setLayout(null);
		getContentPane().add(start_Page);
		getContentPane().add(drawing_Page);
		getContentPane().add(gaming_Page);
		switchPage(1);	
	}
	
	// control the showing page
	public static void switchPage(int desired_page) {
		switch (desired_page) {
			case(1):
				start_Page.setVisible(true);
				drawing_Page.setVisible(false);
				gaming_Page.setVisible(false);
				break;
			case(2):
				start_Page.setVisible(false);
				drawing_Page.setVisible(true);
				gaming_Page.setVisible(false);
				
				break;
			case(3):
				start_Page.setVisible(false);
				drawing_Page.setVisible(false);
				gaming_Page.setVisible(true);
				//if(callfromlisten){
				//	System.out.println("Do Nothing,Just change");
				//}else{
					gaming_Page.putMJ();
				//}
				break;
		}
	}
	
	public void reStart(){
		RenewPanel();
		switchPage(1);
	}
	
	public void RenewPanel(){
		remove(start_Page);
		remove(drawing_Page);
		remove(gaming_Page);
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