//test for cell table

public class CellTableTest{
	public static void main(String [] args){

		Cell[][] init = new Cell[5][5];
		for(int i = 0; i< 5; i++){
			for(int j = 0; j< 5; j++){
				init[i][j] = new Cell();
			}
		}
		init[2][3].setStatus(true);
		init[0][0].setStatus(true);
		init[1][1].setStatus(true);
		init[2][0].setStatus(true);
		//init[3][4]
		CellTable firstTable = new CellTable(init);
		firstTable.display();

		for(int i = 0; i< 5; i++){
			System.out.print("\n");
			for(int j = 0; j< 5; j++){
				System.out.print(firstTable.getNeighbors(i,j) + " ");

			}
		}

		firstTable.newGeneration();
		System.out.println("");
		firstTable.display();

		firstTable.newGeneration();
		System.out.println("");
		firstTable.display();
		firstTable.newGeneration();
		System.out.println("");
		firstTable.display();
		
	}

}