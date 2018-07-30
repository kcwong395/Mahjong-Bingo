package MahJong_Bingo;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ChessColumn extends JLabel{
	int index;
	boolean IsSet = false;
	public ChessColumn(int index,Color bgcolor){
		this.index = index;
		setText(String.valueOf(index));
		setForeground(Color.red);
		setOpaque(true);
		setBackground(bgcolor);
		setSize(100,100);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		this.addMouseListener(listener);
	}
	public Point getLoc(){
		return this.getLocation();
	}
	
	public boolean getSet(){
		return IsSet;
	}
	
	public void toSet(boolean bool){
		IsSet = bool;
	}
	
	private MouseListener listener  =  new MouseAdapter() {

		@Override
		public void mouseClicked(MouseEvent  e) {
			// TODO Auto-generated method stub
			System.out.println(index);
			if(gaming_page.ClickMJ){
				System.out.println("Select something, right?");
				if(gaming_page.select_value==index){
					System.out.println("Match");
					toSet(true);
					gaming_page.PutOnChessCol(index,getLoc());
				}else{
					System.out.println("Not Match");
				}
			}
		}
	};
}
