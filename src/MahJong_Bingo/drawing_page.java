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
		
		ArrayList<Integer> mjtable = new ArrayList();
		for(int i=0;i<36;i++){  // to add tiles to the arraylist (in a style of 1:id, 2:id ... and so on
			mjtable.add(i);
		}
		
		// this part is to assign a random id (without repeated) to each tile
		
		int count = 0;
		if(!cheat){
			while(mjtable.size()>0){
				int id =(int) (mjtable.size()*Math.random());
				mjnum[count]=mjtable.get(id);	// assign a random number to every tile as their id
				mjtable.remove(id);	// remove the used id
				count++;
			}
		}else{
			for(int i=0;i<mjnum.length;i++){
				mjnum[i] = i;
			}
		}

		
		
		//for testing
		

		
		// new mahjong tiles for drawing
		
		drawing_tile(); // new mahjong tiles for drawing
		
		// set up background
		JLabel background_label = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		background_label.setIcon(new ImageIcon(background));
		background_label.setBounds(0, 0, 1200, 700);
		add(background_label,1,0);
		Control_Framework.gril = new GrilStitch();
		Control_Framework.boy = new Stitch();
		add(Control_Framework.gril,2,0);
		add(Control_Framework.boy,2,0);
		//JLabel grilwall = new JLabel();
		//grilwall.setBounds(900, 300, 300, 300);
		//add(grilwall,3,0);
		Control_Framework.gril.setLocation(900, 270);
		Control_Framework.boy.setLocation(0, 250);
		Control_Framework.girldialog = new JLabel("");
		Control_Framework.girldialog.setFont(new Font("Serif", Font.BOLD, 20));
		Control_Framework.girldialog.setBounds(900, 200, 250, 50);
		Control_Framework.girldialog.setText("½Ð¿ï¾Ü¤Q¤­­Ó³Â±N");
		Control_Framework.girldialog.setBackground(Color.WHITE);
		Control_Framework.girldialog.setOpaque(true);
		Control_Framework.gril.setLocation(900, 270);
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
		for(int row = 0; row < 6; row++) {
			for(int col = 0; col < 6; col++) {
				final int rowF = row;
				final int colF = col;
				tile[row][col] = new MJ_Card(mjnum[row * 6 + col], col, row, new ImageIcon(this.getClass().getResource("/face-down-128px.png")).getImage()); // id, column to design x, row to design y, icon image
				System.out.println();
				tile[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if(drawedCount < 15) {
							if(!tile[rowF][colF].Selected()){
								//tile[rowF][colF].setVisible(false);
								tile[rowF][colF].SetLoc(((drawedCount)*50)+200, 580);
								tile[rowF][colF].setLocation(tile[rowF][colF].GetCol(), tile[rowF][colF].GetRow());
								drawedCount++;
								tile[rowF][colF].ToString(); // pls modify this method to show the tiles'id and wt value does this id represent!! (for example: 1 = Ò»Èf£¬2=ƒÉÈf, etc)
								System.out.println(tile[rowF][colF].GetId());
								tile[rowF][colF].Select();
								if(drawedCount==15){
									add(gameBegin,3,0);	
									Control_Framework.boydialog.setText("«östart¶}©l¹CÀ¸§a~");
									Control_Framework.boydialog.setVisible(true);
									Control_Framework.girldialog.setVisible(false);
								}
							}
						}else{
							if(listCardSection){
								
								if(canlist < 3){
									if(!tile[rowF][colF].Selected()){
										
										//tile[rowF][colF].setVisible(false);
										tile[rowF][colF].SetLoc(((canlist)*50)+200, 580);
										tile[rowF][colF].setLocation(tile[rowF][colF].GetCol(), tile[rowF][colF].GetRow());
										canlist++;
										tile[rowF][colF].ToString(); // pls modify this method to show the tiles'id and wt value does this id represent!! (for example: 1 = Ò»Èf£¬2=ƒÉÈf, etc)
										System.out.println(tile[rowF][colF].GetId());
										tile[rowF][colF].Select();
										if(canlist==3)gameBegin.setVisible(true);
									
								}
							}
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
		Control_Framework.boydialog.setText("©ñ±ó§a");
		Control_Framework.boydialog.setVisible(true);
		Control_Framework.girldialog.setText("¥[ªoªü,ÁÙ¦³¾÷·|");
		Control_Framework.girldialog.setVisible(true);
		
	}
	
	public static void renewdialog(){
		Control_Framework.drawing_Page.remove(Control_Framework.boydialog);
		Control_Framework.drawing_Page.remove(Control_Framework.girldialog);
		Control_Framework.gril.setLocation(900, 270);
		Control_Framework.boy.setLocation(0, 250);
		Control_Framework.girldialog = new JLabel("");
		Control_Framework.girldialog.setFont(new Font("Serif", Font.BOLD, 20));
		Control_Framework.girldialog.setBounds(900, 200, 200, 50);
		Control_Framework.girldialog.setText("½Ð¿ï¾Ü¤Q¤­±iµP²Õ");
		Control_Framework.girldialog.setBackground(Color.WHITE);
		Control_Framework.girldialog.setOpaque(true);
		Control_Framework.gril.setLocation(900, 270);
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
	
	public static MJ_Card[][] GetMJ(){
		return tile;
	}
}