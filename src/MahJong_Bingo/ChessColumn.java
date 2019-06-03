package MahJong_Bingo;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ChessColumn extends JLabel implements MouseMotionListener,MouseListener{
	int index;
	boolean IsSet = false;
	public ChessColumn(int index,Color bgcolor){
		this.index = index;
		setForeground(Color.red);
		setSize(90,90);
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);
		this.addMouseListener(listener);
		this.addMouseMotionListener(this);
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
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(gaming_page.ClickMJ)gaming_page.selectMJ.setLocation(this.getX()+arg0.getX()+5, this.getY()+arg0.getY()+5);
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(gaming_page.ClickMJ)gaming_page.selectMJ.setLocation(this.getX()+arg0.getX()+5, this.getY()+arg0.getY()+5);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.printf("Chess ID =\t%d\n",this.index);
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
}
