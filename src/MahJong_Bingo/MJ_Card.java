package MahJong_Bingo;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class MJ_Card extends JButton implements MouseMotionListener{

	private int mj_id, col, row, org_x, org_y;
	private Image backview, frontview;
	private boolean flag = false;
	private boolean stage = false;
	public MJ_Card(int mj_id, int col, int row, Image backview){
		this.mj_id = mj_id;
		this.col = col;
		this.row = row;
		setIcon(new ImageIcon(backview));
		this.backview = backview;
		setOpaque(true);
		setContentAreaFilled(false);
		setBorderPainted(false);
		SetLoc(col, row);
		this.addMouseMotionListener(this);
	}
	
	public void ChangeFront(){
		frontview = new ImageIcon(this.getClass().getResource("/"+(mj_id+1)+".png")).getImage();
		setIcon(new ImageIcon(frontview));
	}
	
	public void ChangeBack(){
		setIcon(new ImageIcon(backview));
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
		setBounds(450 + 50 * col, 75 + 75 * row, 50, 75);
	}
	
	public void setOrg(int orgx,int orgy){
		this.org_x = orgx;
		this.org_y = orgy;
	}
	
	public void backOrg(){
		this.setLocation(this.org_x, this.org_y);
	}
	
	public int GetCol(){
		return this.col;
	}
	
	public boolean Selected(){
		return flag;
	}
	
	public void Select(){
		flag = true;
	}
	
	public void DelSelect(){
		flag = false;
	}
	public int GetRow(){
		return this.row;
	}
	
	public void ToString(){
		System.out.printf("This is %d, x = %d, and y = %d\n", mj_id, 450 + 50 * col, 125 + 75 * row);
	}
	
	public void putlistner(){
		addActionListener(listener);
	}
	
	public void rmlistener(){
		this.removeActionListener(listener);
	}
	
	public void SetStage(boolean s){
		stage = s;
	}
	
	private ActionListener listener  =  new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.printf("This is %d\n",mj_id);
			stage = !stage; //toggle the stage
			if(stage){
				ChangeFront();
				gaming_page.SetClickMJ(true);
			}else{
				ChangeBack();
				gaming_page.SetClickMJ(false);
			}
			gaming_page.BlockAllButSelect(mj_id);
		}
	};
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(gaming_page.ClickMJ)gaming_page.selectMJ.setLocation(this.getX()+arg0.getX()+5, this.getY()+arg0.getY()+5);
	}
}
