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
		setBounds(0, 0, 1200, 700);
		
		// set up button for starting a new game
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control_Framework.switchPage(2);
			}
		});
<<<<<<< HEAD
		btnNewGame.setBounds(525, 350, 150, 70);
=======
		btnNewGame.setBounds(525, 200, 150, 70);
>>>>>>> f2f726b0de3afc8c6f651558c10816aa1921c851
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
				JOptionPane.showMessageDialog(Control_Framework.start_Page, gameRules, "Game Rules",JOptionPane.INFORMATION_MESSAGE);
			}
		});
<<<<<<< HEAD
		btnGameRules.setBounds(525, 450, 150, 70);
=======
		btnGameRules.setBounds(525, 425, 150, 70);
>>>>>>> f2f726b0de3afc8c6f651558c10816aa1921c851
		add(btnGameRules);
		
		// set up button which contains developers' info
		JButton btnDeveloperInfo = new JButton("Developers' Info");
		String info = "This little program is developed by Kevin Kwong, Martin Wong and Ken Teng for the NCKU exchange project.\n"
				+ "Acknowlegdement:\n"
				+ "Our team would like to thank Martin Persson for publicing these mahjong icons.";
		btnDeveloperInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(Control_Framework.start_Page, info, "Developers' Information",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeveloperInfo.setBounds(525, 550, 150, 70);
		add(btnDeveloperInfo);
		
		// set up background
		JLabel background_label = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		background_label.setIcon(new ImageIcon(background));
		background_label.setBounds(0, 0, 1200, 700);
		add(background_label);
	}
}
