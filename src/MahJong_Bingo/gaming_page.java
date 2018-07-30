package MahJong_Bingo;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class gaming_page extends JPanel {
	static ChessColumn[][] mj_col;
	MJ_Card[][] cardmap;
	static ArrayList<MJ_Card> Cur_MJ;
	public static boolean ClickMJ = false;
	static int select_value;
	static int[][] checkmap = new int[6][6];
	public gaming_page() {
		Cur_MJ = new ArrayList<MJ_Card>();
		setVisible(false);
		setLayout(null);
		setBounds(0, 0, 1200, 700);
		//cardmap = drawing_page.GetMJ();
		//for(int i=0;i<6;i++){
		//	for(int j=0;j<6;j++){
		//		add(cardmap[i][j]);
		//		cardmap[i][j].setLocation(cardmap[i][j].GetCol(), cardmap[i][j].GetRow());
		//		cardmap[i][j].setVisible(true);
		//	}
		//}
		JLabel background_label = new JLabel("");
		Image background = new ImageIcon(this.getClass().getResource("/background.jpg")).getImage();
		background_label.setIcon(new ImageIcon(background));
		background_label.setBounds(0, 0, 1200, 700);
		add(background_label,1,0);
		//JLabel testlabel = new JLabel(String.valueOf(1));
		//testlabel.setBounds(50,200,100,100);
		//testlabel.setOpaque(true);
		//testlabel.setBackground(Color.red);
		//add(testlabel,2,0);
		mj_col = new ChessColumn[6][6];
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				int chessid = ((i*5)+j)%2;
				Color cur_color;
				if(chessid==1){
					cur_color = Color.WHITE;
				}else{
					cur_color = Color.BLACK;
				}
				mj_col[i][j] = new ChessColumn(((i*6)+j),cur_color);
				mj_col[i][j].setLocation((j*100)+250, i*100);
				add(mj_col[i][j],2,0);
			}
		}
	}
	public void putMJ(){
		cardmap = drawing_page.GetMJ();
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				final int row = i;
				final int col = i;
				if(cardmap[i][j].Selected()){
				add(cardmap[i][j],3,0);
				cardmap[i][j].setLocation(cardmap[i][j].GetCol(), cardmap[i][j].GetRow());
				cardmap[i][j].setVisible(true);
				/*
				cardmap[i][j].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent evt) {
						System.out.println("Hi");
						System.out.println(evt.getClass().getName());
						cardmap[row][col].ChangeFront();
					}
				});
				*/
				cardmap[i][j].putlistner();
				//cardmap[i][j].ChangeFront();
				Cur_MJ.add(cardmap[i][j]);
				
				}
			}
		}
		
	}
	
	public static int FindIndex(int id){
		for(int i=0;i<Cur_MJ.size();i++){
			if(Cur_MJ.get(i).GetId()==id)return i;
		}
		return 0;
	}
	
	public static void PutOnChessCol(int index,Point loc){
		int idx = FindIndex(index);
		Cur_MJ.get(idx).setLocation(loc);
		Cur_MJ.get(idx).rmlistener();
		Cur_MJ.remove(idx);
		CheckMap();
		SetClickMJ(false);
		if(Cur_MJ.size()==0){
			CheckResult();
		}
	}
	
	public static void CheckResult(){
		JOptionPane.showMessageDialog(Control_Framework.start_Page, "Oops, Maybe next time you will win", "GameOver",JOptionPane.INFORMATION_MESSAGE);
		Control_Framework.main_frame.RenewPanel();
		Control_Framework.main_frame.switchPage(1);
	}
	
	public static void BlockAllButSelect(int select){
		select_value = select;
		for(int i=0;i<Cur_MJ.size();i++){
			if(Cur_MJ.get(i).GetId()!=select){
				Cur_MJ.get(i).SetStage(false);
				Cur_MJ.get(i).ChangeBack();
			}
		}
	}
	
	public static void CheckMap(){
		for(int i=0;i<mj_col.length;i++){
			for(int j=0;j<mj_col[i].length;j++){
				if(mj_col[i][j].IsSet==false){
					checkmap[i][j]=0;
				}else{
					checkmap[i][j]=1;
				}
				System.out.printf("%d\t",checkmap[i][j]);
			}
			System.out.println("");
		}
	}
	
	public static void SetClickMJ(boolean bool){
		ClickMJ = bool;
	}
	
}
