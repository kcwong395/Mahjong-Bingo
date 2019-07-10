package MahJong_Bingo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Stitch extends JLabel implements MouseMotionListener{
	Image outlook;
	public Stitch(boolean isBoy){
		if(isBoy) {
			// outlook for stitch in normal mode and cheating mode
			if(Control_Framework.drawing_Page.cheat){
				outlook= new ImageIcon(this.getClass().getResource("/Stitch_Re.png")).getImage();
			}
			else{
				outlook= new ImageIcon(this.getClass().getResource("/Stitch.png")).getImage();
			}
		}
		else {
			// outlook for angel
			outlook= new ImageIcon(this.getClass().getResource("/Angel_transparent_try.png")).getImage();
		}
		
		this.setIcon(new ImageIcon(outlook));
		this.setSize(300,300);
		this.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if(isBoy) {
					drawing_page.ClickBoyCount++;
					// get into cheat mode if 10 times is clicked
					if(drawing_page.ClickBoyCount>=10){
						Control_Framework.boydialog.setText("進入作弊模式");
						Control_Framework.boydialog.setVisible(true);
						drawing_page.cheat = true;
						outlook= new ImageIcon(this.getClass().getResource("/Stitch_Re.png")).getImage();
						setIcon(new ImageIcon(outlook));
					}
				}
			}
// <------------------------------------------------------- unused code ---------------------------------------------------------->
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			
		});
		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}