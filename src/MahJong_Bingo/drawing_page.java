package MahJong_Bingo;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class drawing_page extends JPanel {

	private int drawedCount = 0;
	JButton gameBegin;
<<<<<<< HEAD
	static MJ_Card tile[][] = new MJ_Card[6][6];
=======
	MJ_Card tile[][] = new MJ_Card[6][6];
>>>>>>> f2f726b0de3afc8c6f651558c10816aa1921c851
	int[] mjnum = new int[36];	// array to store id of tile
	
	public drawing_page() {
		setVisible(false);
		setLayout(null);
		setBounds(0, 0, 1200, 700);
		
<<<<<<< HEAD
		// After drawing 15 tiles, this button will appear and bring user to gaming page
=======
>>>>>>> f2f726b0de3afc8c6f651558c10816aa1921c851
		gameBegin = new JButton("Start");
		gameBegin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			Control_Framework.switchPage(3);
			}
		});
		gameBegin.setBounds(525, 315, 150, 70);
<<<<<<< HEAD
		
		ArrayList<Integer> mjtable = new ArrayList();
		for(int i=0;i<36;i++){  // to add tiles to the arraylist (in a style of 1:id, 2:id ... and so on
			mjtable.add(i);
		}
		
		// this part is to assign a random id (without repeated) to each tile
		int count = 0;
		while(mjtable.size()>0){
			int id =(int) (mjtable.size()*Math.random());
			mjnum[count]=mjtable.get(id);	// assign a random number to every tile as their id
			mjtable.remove(id);	// remove the used id
			count++;
		}
		
		// new mahjong tiles for drawing
		drawing_tile(); 
=======
		
		drawing_tile(); // new mahjong tiles for drawing
>>>>>>> f2f726b0de3afc8c6f651558c10816aa1921c851
		
		// set up background
		JLabel background_label = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		background_label.setIcon(new ImageIcon(background));
		background_label.setBounds(0, 0, 1200, 700);
		add(background_label);
		
		ArrayList<Integer> mjtable = new ArrayList();
		for(int i=0;i<36;i++){  // to add tiles to the arraylist
			mjtable.add(i);
		}
		
		// this part is to assign a random id (without repeated) to each tile
		int count = 0;
		while(mjtable.size()>0){
			int id =(int) (mjtable.size()*Math.random());
			mjnum[count]=mjtable.get(id);	// assign a random number to every tile as their id
			mjtable.remove(id);	// remove the used id
			count++;
		}
	}
	
	// assigning tiles location & importing pic
	public void drawing_tile() {
<<<<<<< HEAD
		
=======
>>>>>>> f2f726b0de3afc8c6f651558c10816aa1921c851
		for(int row = 0; row < 6; row++) {
			for(int col = 0; col < 6; col++) {
				final int rowF = row;
				final int colF = col;
<<<<<<< HEAD
				tile[row][col] = new MJ_Card(mjnum[row * 6 + col], col, row, new ImageIcon(this.getClass().getResource("/face-down-128px.png")).getImage()); // id, column to design x, row to design y, icon image
				System.out.println();
				tile[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if(drawedCount < 15) {
							//tile[rowF][colF].setVisible(false);
							tile[rowF][colF].SetLoc((drawedCount)*50, 570);
							tile[rowF][colF].setLocation(tile[rowF][colF].GetCol(), tile[rowF][colF].GetRow());
							drawedCount++;
							tile[rowF][colF].ToString(); // pls modify this method to show the tiles'id and wt value does this id represent!! (for example: 1 = Ò»Èf£¬2=ƒÉÈf, etc)
							System.out.println(tile[rowF][colF].GetId());
							
							
						} else {
							add(gameBegin);
							//setComponentZOrder(gameBegin, 0);
							gameBegin.setVisible(true);
=======
				tile[rowF][colF] = new MJ_Card(mjnum[row * 6 + col], col, row, new ImageIcon(this.getClass().getResource("/face-down-128px.png")).getImage()); // id, column to design x, row to design y, icon image
				tile[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						tile[rowF][colF].setVisible(false);
						drawedCount++;
						tile[rowF][colF].ToString(); // pls modify this method to show the tiles'id and wt value does this id represent!! (for example: 1 = Ò»Èf£¬2=ƒÉÈf, etc)
						if(drawedCount == 15) {
							add(gameBegin);
>>>>>>> f2f726b0de3afc8c6f651558c10816aa1921c851
						}
					}
				});
				add(tile[row][col]);
			}	
		}
	}
<<<<<<< HEAD
	
	public static MJ_Card[][] GetMJ(){
		return tile;
	}
=======
>>>>>>> f2f726b0de3afc8c6f651558c10816aa1921c851
}