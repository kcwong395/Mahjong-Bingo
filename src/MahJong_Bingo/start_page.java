package MahJong_Bingo;

import javax.swing.JPanel;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class start_page extends JPanel {
	
	// panel initialization
	public start_page() {
		setVisible(false);
		setLayout(null);
		setBounds(0, 0, 1200, 700);
		
		// set up button for starting a new game
		JButton btnNewGame = new JButton();
		this.SetJbutton(btnNewGame,
						new ImageIcon(this.getClass().getResource("/start_game.png")).getImage(),
						new ImageIcon(this.getClass().getResource("/start_game_active.png")).getImage());
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control_Framework.switchPage(2);
			}
		});
		btnNewGame.setBounds(500, 350, 190, 80);
		
		// set up button for explaining game rules
		JButton btnGameRules = new JButton();
		this.SetJbutton(btnGameRules,
						new ImageIcon(this.getClass().getResource("/game_rules.png")).getImage(),
						new ImageIcon(this.getClass().getResource("/game_rules_active.png")).getImage());
		String gameRules = "Game Rules:\r\n" + 
				"1) Draw 15 face-down Mahjong tiles.\r\n" + 
				"2) Click to reveal the tiles.\r\n" + 
				"3) Drag the tiles to the correspondent place which shares the same picture.\r\n" + 
				"4) If any six of the tiles complete a line, you win.\r\n" + 
				"5) Get extra 3 tiles and continue the game if there are five tiles connected while no line is completed. \r\n" + 
				"\r\n" + 
				"絿��ㄩ\r\n" + 
				"1ㄘ喲堤坋拻��齪\r\n" + 
				"2ㄘ鎊眕楹嶱齪醱\r\n" + 
				"3ㄘ迍嶺鎊祫偶\r\n" + 
				"4ㄘ衄鞠��瞎傖珨�ㄗ眻訇諂褫ㄘㄛ��瞳\r\n" + 
				"5ㄘ帤絻傖瞳璃ㄛ筍衄砩拻�頍B腔齪ㄛ陂腕謞俋腔��餞鴦絿";
		btnGameRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(Control_Framework.start_Page, gameRules, "Game Rules",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnGameRules.setBounds(500, 450, 190, 80);
		
		// set up button which contains developers' info
		JButton btnDeveloperInfo = new JButton("Developers' Info");
		this.SetJbutton(btnDeveloperInfo,
						new ImageIcon(this.getClass().getResource("/develop.png")).getImage(),
						new ImageIcon(this.getClass().getResource("/develop_active.png")).getImage());
		String info = "This little program is developed by Kevin Kwong, Martin Wong and Ken Teng for the NCKU exchange project.\n"
				+ "Acknowlegdement:\n"
				+ "Our team would like to thank Martin Persson for publicing these mahjong icons.";
		btnDeveloperInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(Control_Framework.start_Page, info, "Developers' Information",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnDeveloperInfo.setBounds(500, 550, 190, 80);
		add(btnNewGame);
		add(btnGameRules);
		add(btnDeveloperInfo);
		
		// set up background
		JLabel background_label = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		background_label.setIcon(new ImageIcon(background));
		background_label.setBounds(0, 0, 1200, 700);
		add(background_label);
		
		JLabel title_label = new JLabel();
		Image title = new ImageIcon(this.getClass().getResource("/title.png")).getImage();
		title_label.setIcon(new ImageIcon(title));
		title_label.setBounds(325,0,600,400);
		add(title_label,2);
	}
	
	public void SetJbutton(JButton btn,Image btn_img,Image btn_actimg){
		btn.setIcon(new ImageIcon(btn_img));
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addMouseListener(new MouseAdapter(){
	         public void mouseEntered(MouseEvent me) {
	     		btn.setIcon(new ImageIcon(btn_actimg));
	          }
	          public void mouseExited(MouseEvent me) {
	      		btn.setIcon(new ImageIcon(btn_img));
	          }
		});
	}
}
