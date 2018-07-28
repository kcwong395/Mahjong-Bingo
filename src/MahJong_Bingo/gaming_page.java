package MahJong_Bingo;

import java.awt.Color;

import javax.swing.JPanel;

public class gaming_page extends JPanel {

	MJ_Card[][] cardmap;
	
	public gaming_page() {
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
	}
	public void putMJ(){
		cardmap = drawing_page.GetMJ();
		for(int i=0;i<6;i++){
			for(int j=0;j<6;j++){
				add(cardmap[i][j]);
				cardmap[i][j].setLocation(cardmap[i][j].GetCol(), cardmap[i][j].GetRow());
				cardmap[i][j].setVisible(true);
			}
		}
	}
}
