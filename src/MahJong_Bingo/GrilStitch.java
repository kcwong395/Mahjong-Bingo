package MahJong_Bingo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class GrilStitch extends JLabel{
	public GrilStitch(){
		Image outlook= new ImageIcon(this.getClass().getResource("/Angel_transparent_try.png")).getImage();
		this.setIcon(new ImageIcon(outlook));
		this.setSize(300,300);
	}
}
