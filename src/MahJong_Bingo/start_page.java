package MahJong_Bingo;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class start_page extends JPanel {
	
	// panel initialization
	public start_page() {
		setVisible(false);
		setLayout(null);
		setBounds(300, 50, 800, 600);
		
		// set up button for starting a new game
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control_Framework.switchPage(2);
			}
		});
		btnNewGame.setBounds(325, 175, 150, 50);
		add(btnNewGame);
		
		// set up button for explaining game rules
		JButton btnGameRules = new JButton("Game Rules");
		String gameRules = "Game Rules:\r\n" + 
				"1) Draw 15 face-down Mahjong tiles.\r\n" + 
				"2) Click to reveal the tiles.\r\n" + 
				"3) Drag the tiles to the correspondent place which shares the same picture.\r\n" + 
				"4) If any six of the tiles complete a line, you win.\r\n" + 
				"5) Get extra 3 tiles and continue the game if there are five tiles connected while no line is completed. \r\n" + 
				"\r\n" + 
				"遊戲規則：\r\n" + 
				"1）抽出十五張麻將牌\r\n" + 
				"2）點擊麻將以翻開牌面\r\n" + 
				"3）拖拉麻將至對應圖案\r\n" + 
				"4）如有六張麻將組成一條線（直橫斜皆可），則視作勝利\r\n" + 
				"5）如未達成勝利條件，但有任意五張相連的牌，則獲得額外的三張牌並繼續遊戲";
		btnGameRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(btnGameRules, gameRules, "Game Rules",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnGameRules.setBounds(325, 375, 150, 50);
		add(btnGameRules);
		
		// set up background
		JLabel background_label = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		background_label.setIcon(new ImageIcon(background));
		background_label.setBounds(0, 0, 800, 600);
		add(background_label);
	}
}
