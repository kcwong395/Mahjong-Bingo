package MahJong_Bingo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class gaming_page extends JPanel implements MouseMotionListener{
	static ChessColumn[][] mj_col;
	MJ_Card[][] cardmap;
	static ArrayList<MJ_Card> Cur_MJ;
	public static boolean ClickMJ = false;
	static int select_value;
	static MJ_Card selectMJ;
	private static boolean endGame = false;
	private static boolean hasbeenListen = false;
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
		JLabel chessTable = new JLabel();
		Image chessTableImg = new ImageIcon(this.getClass().getResource("/gameTable.png")).getImage();
		chessTable.setIcon(new ImageIcon(chessTableImg));
		chessTable.setBounds(300, 30, 540, 540);
		add(chessTable,1,0);
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
				mj_col[i][j].setLocation((j*90)+300, (i*90)+30);
				add(mj_col[i][j],2,0);
			}
		}
		this.addMouseMotionListener(this);
		Control_Framework.girl = new Stitch(false);
		Control_Framework.boy = new Stitch(true);
		add(Control_Framework.girl,2,0);
		add(Control_Framework.boy,2,0);
		Control_Framework.girl.setLocation(900, 270);
		Control_Framework.boy.setLocation(0, 250);
		Control_Framework.girl.setLocation(900, 270);
		Control_Framework.boy.setLocation(0, 250);
	}
	
	public void addDialog(){
		Control_Framework.girldialog = new JLabel("");
		Control_Framework.girldialog.setBounds(900, 200, 250, 50);
		Control_Framework.girldialog.setFont(new Font("Serif", Font.BOLD, 20));
		Control_Framework.girldialog.setText("請選擇十五個麻雀");
		Control_Framework.girldialog.setBackground(Color.WHITE);
		Control_Framework.girldialog.setOpaque(true);
		Control_Framework.boydialog = new JLabel("");
		Control_Framework.boydialog.setBounds(30, 200, 250, 50);
		Control_Framework.boydialog.setFont(new Font("Serif", Font.BOLD, 20));
		Control_Framework.boydialog.setText("Hello, I am a Boy");
		Control_Framework.boydialog.setBackground(Color.WHITE);
		Control_Framework.boydialog.setOpaque(true);
		add(Control_Framework.girldialog,2,0);
		add(Control_Framework.boydialog,2,0);
		Control_Framework.boydialog.setVisible(false);
		Control_Framework.girldialog.setVisible(false);
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
				cardmap[i][j].setOrg(cardmap[i][j].GetCol(), cardmap[i][j].GetRow());
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
		Cur_MJ.get(idx).DelSelect();
		Cur_MJ.remove(idx);
		CheckMap();
		SetClickMJ(false);
		/*
		if(Cur_MJ.size()==0){
			CheckResult();
		}
		*/
	}
	
	public static void BlockAllButSelect(int select){
		select_value = select;
		for(int i=0;i<Cur_MJ.size();i++){
			if(Cur_MJ.get(i).GetId()!=select){
				Cur_MJ.get(i).SetStage(false);
				Cur_MJ.get(i).ChangeBack();
				Cur_MJ.get(i).backOrg();
			}else{
				selectMJ =Cur_MJ.get(i);
				//System.out.println(Control_Framework.gaming_Page.getComponentZOrder(selectMJ));
				//Control_Framework.gaming_Page.setComponentZOrder(selectMJ, 36);
				Control_Framework.gaming_Page.remove(selectMJ);
				Control_Framework.gaming_Page.add(selectMJ,5,0);
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
		SumColRow();
		SumSlash();
	}
	
	// check the tiles in same column and row
	public static void SumColRow(){
		int col = 0;
		int row = 0;
		for(int i=0;i<mj_col.length;i++){
			for(int j=0;j<mj_col.length;j++){
				col += checkmap[i][j];
				row += checkmap[j][i];
			}
			System.out.printf("Row %d:\t%d\tCol %d:\t%d\n",i,col,i,row);
			CheckResult(col,row);
			if(endGame) break;
			col = 0;
			row = 0;
		}
	}
	
	// check slash
	public static void SumSlash(){
		for(int i=0;i<checkmap.length;i++){
			for(int k=0;k<checkmap[i].length;k++){
				int sumlefttoright = 0;
				int sumrighttoleft = 0;
				if((k-0>=4 || 5-k>=4) && (i-0>=4 || 5-i>=4)){
					if(5-k>=4 && (5-i>=4)){
						int col = k;
						int search = 5-k;
						for(int j=i;j<=search;j++){
							sumlefttoright += checkmap[j][col++];
						}
						System.out.printf("row = %d , col = %d ,Left to Right Slash = %d\n",i,k,sumlefttoright);
					}
					if(k>=4 && (5-i>=4)){
						int search = k;
						int row = 0;
						for(int r=search;r>=0;r--){
							sumrighttoleft += checkmap[row++][r];
						}
						System.out.printf("row = %d , col = %d ,Right to Left Slash = %d\n",i,k,sumrighttoleft);
					}
					if(endGame) break;
					CheckResult(sumlefttoright,sumrighttoleft);
				}
			}	
		}	
	}
	
	// this check if the player can get extra cards or wins after each tiles placement
	public static void CheckResult(int resultA, int resultB){
		if(resultA > 5 || resultB > 5){
			Control_Framework.girldialog.setText("下次再來玩哦");
			Control_Framework.boydialog.setText("可惡....");
			Control_Framework.girldialog.setVisible(true);
			Control_Framework.boydialog.setVisible(true);
			JOptionPane.showMessageDialog(Control_Framework.start_Page, "你成功了,運氣真好!!!", "獲勝",JOptionPane.INFORMATION_MESSAGE);
			Control_Framework.main_frame.RenewPanel();
			Control_Framework.main_frame.switchPage(1);
			hasbeenListen = false;
			endGame = true;
		}
		else if((resultA == 5 || resultB == 5) && !hasbeenListen && Cur_MJ.size() == 0){
			JOptionPane.showMessageDialog(Control_Framework.start_Page, "你可以聽牌了!!!", "聽牌階段",JOptionPane.INFORMATION_MESSAGE);					
			Control_Framework.boydialog.setText("可以聽牌不等於嬴喔~");
			Control_Framework.boydialog.setVisible(true);
			Control_Framework.girldialog.setVisible(false);
			Control_Framework.gaming_Page.remove(Control_Framework.boydialog);
			Control_Framework.gaming_Page.remove(Control_Framework.girldialog);
			Control_Framework.drawing_Page.renewdialog();
			drawing_page.ListenCard();
			Control_Framework.main_frame.switchPage(2);
			hasbeenListen = true;
		}
		else if(Cur_MJ.size() == 0) {
			Control_Framework.boydialog.setText("人類總是要犯同一個錯誤");
			Control_Framework.girldialog.setText("還有下一次的");
			Control_Framework.boydialog.setVisible(true);
			Control_Framework.girldialog.setVisible(true);
			JOptionPane.showMessageDialog(Control_Framework.start_Page, "勝敗乃兵家常事,大俠請重新投幣", "Gameover",JOptionPane.INFORMATION_MESSAGE);
			Control_Framework.main_frame.RenewPanel();
			Control_Framework.main_frame.switchPage(1);
			hasbeenListen = false;
			endGame = true;
		}
	}
	
	public static void SetClickMJ(boolean bool){
		ClickMJ = bool;
	}
	@Override
	public void mouseDragged(MouseEvent arg0){
		// TODO Auto-generated method stub
		if(this.ClickMJ)this.selectMJ.setLocation(arg0.getX()+5, arg0.getY()+5);
	}
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(this.ClickMJ)this.selectMJ.setLocation(arg0.getX()+5, arg0.getY()+5);
	}

	
}
