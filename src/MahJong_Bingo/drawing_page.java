package MahJong_Bingo;

import java.awt.Color;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class drawing_page extends JPanel {

	public drawing_page() {
		setVisible(false);
		setLayout(null);
		setBounds(0, 0, 800, 600);
		Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		
		// set mahjong tiles icon and new mahjong button
		JButton mahjong = new JButton("");
		Image mahjongTest = new ImageIcon(this.getClass().getResource("/flower-chrysanthemum-3.png")).getImage();
		mahjong.setIcon(new ImageIcon(mahjongTest));
		mahjong.setBounds(200, 200, 86, 129);
		mahjong.setOpaque(false);
		mahjong.setContentAreaFilled(false);
		mahjong.setBorderPainted(false);
		add(mahjong);
		
		// set up background
		JLabel background_label = new JLabel("");
		background_label.setIcon(new ImageIcon(background));
		background_label.setBounds(0, 0, 800, 600);
		add(background_label);
	}

}
