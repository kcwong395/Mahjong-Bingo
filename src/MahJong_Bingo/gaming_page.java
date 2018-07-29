package MahJong_Bingo;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gaming_page extends JPanel {

	MJ_Card[][] cardmap;
	static ArrayList<MJ_Card> Cur_MJ;
	public gaming_page() {
		Cur_MJ = new ArrayList<MJ_Card>();
		setVisible(false);
		setLayout(null);
		setBounds(0, 0, 1200, 700);
		setBackground(Color.YELLOW);
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
		
	}
	public void putMJ(){
		cardmap = drawing_page.GetMJ();
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				final int row = i;
				final int col = i;
				if(cardmap[i][j].Selected()){
				add(cardmap[i][j],2,0);
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
	public static void BlockAllButSelect(int select){
		for(int i=0;i<Cur_MJ.size();i++){
			if(Cur_MJ.get(i).GetId()!=select){
				Cur_MJ.get(i).SetStage(false);
				Cur_MJ.get(i).ChangeBack();
			}
		}
	}
}
