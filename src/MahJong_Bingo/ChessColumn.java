package MahJong_Bingo;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

public class ChessColumn extends JLabel{
	int index;
	public ChessColumn(int index,Color bgcolor){
		this.index = index;
		setText(String.valueOf(index));
		setForeground(Color.red);
		setOpaque(true);
		setBackground(bgcolor);
		setSize(100,100);
		this.addMouseListener(listener);
	}
	public Point getLoc(){
		return this.getLocation();
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
					gaming_page.PutOnChessCol(index,getLoc());
				}else{
					System.out.println("Not Match");
				}
			}
		}
	};
}
