import java.awt.Image;
import javax.swing.ImageIcon;

public class MJ_Card extends ImageIcon{

	private int mj_id,x,y;
	private Image backview;
	
	public MJ_Card(int id,int x,int y){
		this.mj_id = id;
		this.x = x;
		this.y = y;
	}
	
	public int GetId(){
		return this.mj_id;
	}
	
	public void SetId(int newid){
		this.mj_id = newid;
	}
	
	public void SetLoc(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void ToString(){
		System.out.printf("This is %d, x = %d, and y = %d\n",mj_id,x,y);
		
		
	}
}
