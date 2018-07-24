import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class MyFrame2 extends JFrame implements KeyListener {
 
	/**
	 * 
	 * 
	 * @param args
	 */
	private static JPanel jp = new JPanel();
	private int x;
	private int y;
 
	public MyFrame2(int x, int y) {
		this.x = x;
		this.y = y;
		this.add(jp);
 
		this.setSize(400, 300);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
 
	public static void main(String[] args) {
		MyFrame2 rb = new MyFrame2(50, 50);
		
		rb.addKeyListener(rb);
	}
 
	public void paint(Graphics g) {
		g.fillOval(this.x, this.y, 8, 8);
 
	}
 
	@Override
	public void keyTyped(KeyEvent e) {
		JOptionPane.showMessageDialog(null, "Pressing");
	}
 
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y++;
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			y--;
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x++;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			x--;
		}
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
 
 

}
