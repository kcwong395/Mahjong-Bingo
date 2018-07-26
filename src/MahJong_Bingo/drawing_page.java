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
	MJ_Card tile[][] = new MJ_Card[6][6];
	int[] mjnum = new int[36];	// array to store id of tile
	
	public drawing_page() {
		setVisible(false);
		setLayout(null);
		setBounds(0, 0, 1200, 700);
		
		gameBegin = new JButton("Start");
		gameBegin.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			Control_Framework.switchPage(3);
			}
		});
		gameBegin.setBounds(525, 315, 150, 70);
		
		drawing_tile(); // new mahjong tiles for drawing
		
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
		for(int row = 0; row < 6; row++) {
			for(int col = 0; col < 6; col++) {
				final int rowF = row;
				final int colF = col;
				tile[rowF][colF] = new MJ_Card(mjnum[row * 6 + col], col, row, new ImageIcon(this.getClass().getResource("/face-down-128px.png")).getImage()); // id, column to design x, row to design y, icon image
				tile[row][col].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						tile[rowF][colF].setVisible(false);
						drawedCount++;
						tile[rowF][colF].ToString(); // pls modify this method to show the tiles'id and wt value does this id represent!! (for example: 1 = Ò»Èf£¬2=ƒÉÈf, etc)
						if(drawedCount == 15) {
							add(gameBegin);
						}
					}
				});
				add(tile[row][col]);
			}	
		}
	}
}