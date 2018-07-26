package MahJong_Bingo;

import java.util.ArrayList;

public class Out_chess {/*
	public static void main(String[] args){
		
		//MJ_Card[][] chess = new MJ_Card[6][6];	
		ArrayList<Integer> mjtable = new ArrayList();
		for(int i=0;i<36;i++){  // to add tiles to the arraylist
			mjtable.add(i);
		}
		
		// this part is to assign a random id (without repeated) to each tile
		int count = 0;
		int[] mjnum = new int[36];	// array to store id of tile
		while(mjtable.size()>0){
			int id =(int) (mjtable.size()*Math.random());
			mjnum[count]=mjtable.get(id);	// assign a random number to every tile as their id
			mjtable.remove(id);	// remove the used id
			count++;
		}
		PrintArr(mjnum);
		// this method shows the tiles' id, x ,y
		for(int y=0;y<chess.length;y++){
			for(int x=0;x<chess[y].length;x++){
				chess[y][x] = new MJ_Card(mjnum[--count],x * 50, y * 75, null);
				chess[y][x].ToString();
			}
		}
		
	}
	
	// this method shows every element in the array
	
	public static void PrintArr(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("");
	}
	*/
}
