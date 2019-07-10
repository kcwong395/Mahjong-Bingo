package MahJong_Bingo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class drawing_page extends JLayeredPane {

	private int drawedCount = 0;
	static JButton gameBegin;
	public static int ClickBoyCount = 0;
	public static int ClickGirlCount = 0;
	public static boolean cheat = false;
	static MJ_Card tile[][] = new MJ_Card[6][6];
	int[] mjnum = new int[36];	// array to store id of tile
	public static boolean listCardSection = false;
	int canlist = 0;
	
	public drawing_page() {
		setVisible(false);
		setLayout(null);
		setBounds(0, 0, 1200, 700);
		listCardSection = false;
		
		// After drawing 15 tiles, this button will appear and bring user to gaming page
		gameBegin = new JButton("Start");
		gameBegin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			Control_Framework.switchPage(3);
			Control_Framework.gaming_Page.addDialog();
			}
		});
		gameBegin.setBounds(525, 315, 150, 70);
		// end of game start button
		
		// initialize the mjtable
		ArrayList<Integer> mjtable = new ArrayList();
		for(int i = 0; i < 36; i++){  // to add tiles to the arraylist (in a style of 1:id, 2:id ... and so on
			mjtable.add(i);
		}
		
		// this part is to assign a random id (without repeated) to each tile
		int count = 0;
		if(!cheat){
			while(mjtable.size() > 0){
				int id = (int)(mjtable.size() * Math.random());
				mjnum[count] = mjtable.get(id);	// assign a random number to every tile as their id
				mjtable.remove(id);	// remove the used id
				count++;
			}
		}
		else{
			for(int i = 0; i < mjnum.length; i++){
				mjnum[i] = i;
			}
		}
		
		// generate mahjong tiles for drawing
		drawing_tile(); 
		
		// set up background
		JLabel background_label = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		background_label.setIcon(new ImageIcon(background));
		background_label.setBounds(0, 0, 1200, 700);
		add(background_label, 1, 0);
		
		// initial stitch
		Control_Framework.girl = new Stitch(false);
		Control_Framework.boy = new Stitch(true);
		add(Control_Framework.girl,2,0);
		add(Control_Framework.boy,2,0);
		Control_Framework.girl.setLocation(900, 270);
		Control_Framework.boy.setLocation(0, 250);
		Control_Framework.girldialog = new JLabel("");
		Control_Framework.girldialog.setFont(new Font("Serif", Font.BOLD, 20));
		Control_Framework.girldialog.setBounds(900, 200, 250, 50);
		Control_Framework.girldialog.setText("請抽取十五張麻將");
		Control_Framework.girldialog.setBackground(Color.WHITE);
		Control_Framework.girldialog.setOpaque(true);
		Control_Framework.girl.setLocation(900, 270);
		Control_Framework.boy.setLocation(0, 250);
		Control_Framework.boydialog = new JLabel("");
		Control_Framework.boydialog.setFont(new Font("Serif", Font.BOLD, 20));
		Control_Framework.boydialog.setBounds(30, 200, 250, 50);
		Control_Framework.boydialog.setText("Hello, I am a Boy");
		Control_Framework.boydialog.setBackground(Color.WHITE);
		Control_Framework.boydialog.setOpaque(true);
		add(Control_Framework.girldialog,2,0);
		add(Control_Framework.boydialog,2,0);
		Control_Framework.boydialog.setVisible(false);
		
	}

	
	// assigning tiles location & importing pic
	public void drawing_tile() {
		
		// reinitialize the tile in order
		if(cheat) {
			for(int i = 0; i < mjnum.length; i++){
				mjnum[i] = i;
			}
			cheat = false;
		}
		
		for(int row = 0; row < 6; row++) {
			for(int col = 0; col < 6; col++) {
				final int rowF = row;
				final int colF = col;
				// id, column to design x, row to design y, icon image
				tile[row][col] = new MJ_Card(mjnum[row * 6 + col], col, row, new ImageIcon(this.getClass().getResource("/face-down-128px.png")).getImage()); 
				tile[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if(cheat) {
							
							// this is to make the existing tiles disappear
							for(int i = 0; i < 6; i++){
								for(int j = 0; j < 6; j++) {
									tile[i][j].setVisible(false);
								}
							}
							
							// reinitialize the tiles
							drawing_tile();
							drawedCount = 0; 
							
						}
						else if(drawedCount < 15) {
							
							// if a tile is selected, move it to the bottom
							if(!tile[rowF][colF].Selected()){
								tile[rowF][colF].SetLoc(((drawedCount++)*50)+200, 580);
								tile[rowF][colF].setLocation(tile[rowF][colF].GetCol(), tile[rowF][colF].GetRow());
								tile[rowF][colF].ToString(); 
								System.out.println(tile[rowF][colF].GetId());
								tile[rowF][colF].Select();
							}
								
							// enable the player to start once 15 tiles are drawled
							if(drawedCount == 15){
								add(gameBegin, 3, 0);	
								Control_Framework.boydialog.setText("快開始吧");
								Control_Framework.boydialog.setVisible(true);
								Control_Framework.girldialog.setVisible(false);
							}
						}
						else if(listCardSection){
							if(canlist < 3 && !tile[rowF][colF].Selected()){
								tile[rowF][colF].SetLoc(((canlist++)*50)+200, 580);
								tile[rowF][colF].setLocation(tile[rowF][colF].GetCol(), tile[rowF][colF].GetRow());
								tile[rowF][colF].ToString();
								System.out.println(tile[rowF][colF].GetId());
								tile[rowF][colF].Select();
							}
							if(canlist == 3) {
								gameBegin.setVisible(true);
								gaming_page.hasbeenListen = true;
							}
						}
					}
				});
				add(tile[row][col],2,0);
				setComponentZOrder(tile[row][col], 0);
			}	
		}
	}
	
	public static void ListenCard(){
		listCardSection = true;
		gameBegin.setVisible(false);
		Control_Framework.boydialog.setVisible(false);
		Control_Framework.girldialog.setText("請抽取三張麻將");
		Control_Framework.girldialog.setVisible(true);
		
	}
	
	public static void renewdialog(){
		Control_Framework.drawing_Page.remove(Control_Framework.boydialog);
		Control_Framework.drawing_Page.remove(Control_Framework.girldialog);
		Control_Framework.girl.setLocation(900, 270);
		Control_Framework.boy.setLocation(0, 250);
		Control_Framework.girldialog = new JLabel("");
		Control_Framework.girldialog.setFont(new Font("Serif", Font.BOLD, 20));
		Control_Framework.girldialog.setBounds(900, 200, 200, 50);
		Control_Framework.girldialog.setText("請抽取十五張麻將");
		Control_Framework.girldialog.setBackground(Color.WHITE);
		Control_Framework.girldialog.setOpaque(true);
		Control_Framework.girl.setLocation(900, 270);
		Control_Framework.boy.setLocation(0, 250);
		Control_Framework.boydialog = new JLabel("");
		Control_Framework.boydialog.setFont(new Font("Serif", Font.BOLD, 20));
		Control_Framework.boydialog.setBounds(30, 200, 200, 50);
		Control_Framework.boydialog.setText("Hello, I am a Boy");
		Control_Framework.boydialog.setBackground(Color.WHITE);
		Control_Framework.boydialog.setOpaque(true);
		Control_Framework.drawing_Page.add(Control_Framework.girldialog,2,0);
		Control_Framework.drawing_Page.add(Control_Framework.boydialog,2,0);
	}
	
	public static MJ_Card[][] GetMJ() {
		return tile;
	}
}