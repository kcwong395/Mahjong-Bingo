import java.util.ArrayList;

public class Out_chess {
	public static void main(String[] args){
		int[] mjnum = new int[36];
		MJ_Card[][] chess = new MJ_Card[6][6];
		ArrayList<Integer> mjtable = new ArrayList();
		for(int i=0;i<36;i++){
			mjtable.add(i);
		}
		int count = 0;
		while(mjtable.size()>0){
			int j=(int) (mjtable.size()*Math.random());
			mjnum[count]=mjtable.get(j);
			mjtable.remove(j);
			count++;
		}
		PrintArr(mjnum);
		for(int y=0;y<chess.length;y++){
			for(int x=0;x<chess[y].length;x++){
				chess[y][x] = new MJ_Card(mjnum[--count],x,y);
				chess[y][x].ToString();
			}
		}
	}
	public static void PrintArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
			
		}
		System.out.println("");
	}
}
