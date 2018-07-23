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
				"�[��Ҏ�t��\r\n" + 
				"1�����ʮ�又�錢��\r\n" + 
				"2���c���錢�Է��_����\r\n" + 
				"3�������錢�������D��\r\n" + 
				"4�����������錢�M��һ�l����ֱ�Mб�Կɣ����tҕ������\r\n" + 
				"5����δ�_�Ʉ����l�������������又���B���ƣ��t�@���~��������ƁK�^�m�[��";
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
