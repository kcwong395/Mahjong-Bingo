package MahJong_Bingo;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GrilStitch extends JLabel implements MouseMotionListener{
	public GrilStitch(){
		Image outlook= new ImageIcon(this.getClass().getResource("/Angel_transparent_try.png")).getImage();
		this.setIcon(new ImageIcon(outlook));
		this.setSize(300,300);
		this.addMouseMotionListener(this);
	}

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
}
