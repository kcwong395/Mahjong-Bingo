package MahJong_Bingo;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MJ_Card extends JButton{

	private int mj_id, col, row;
	private Image backview;
	
	public MJ_Card(int mj_id, int col, int row, Image backview){
		this.mj_id = mj_id;
		this.col = col;
		this.row = row;
		setIcon(new ImageIcon(backview));
		setOpaque(true);
		setContentAreaFilled(false);
		setBorderPainted(false);
		SetLoc(col, row);
	}
	
	public int GetId(){
		return this.mj_id;
	}
	public void SetId(int newid){
		this.mj_id = newid;
	}
	
	public void SetLoc(int col,int row){
		this.col = col;
		this.row = row;
		setBounds(450 + 50 * col, 125 + 75 * row, 50, 75);
	}
	
	public void ToString(){
		System.out.printf("This is %d, x = %d, and y = %d\n", mj_id, 450 + 50 * col, 125 + 75 * row);
	}
	
}
