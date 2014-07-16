/** This class will implement {@code CellTableInterface}. It 
	will be responsible for knowing the current state of all
	of its cells and be able to update the table based on its
	current state. It is also responsible for displaying its
	current state.

	@author Brian McEntee
	@version 7.16.2014 */

public class CellTable implements CellTableInterface{

	private Cell[][] currStatusGrid;
	private Cell[][] tempStatusGrid; //strictly for updating

	// @args These are needed for creating the grids
	public CellTable(Cell[][] initialGrid){
		currStatusGrid = new Cell[initialGrid.length][initialGrid[0].length];
		tempStatusGrid = new Cell[initialGrid.length][initialGrid[0].length];

		for(int currRow = 0; currRow < currStatusGrid.length; currRow++){
			for(int currCol = 0; currCol < currStatusGrid[0].length; currCol++){
				currStatusGrid[currRow][currCol] = new Cell(initialGrid[currRow][currCol].getStatus());
				tempStatusGrid[currRow][currCol] = new Cell(initialGrid[currRow][currCol].getStatus());
			}
		}
	}

	public void newGeneration(){
		this.copyToTempGrid(); //store contents of status'

		//re-configure table based on previous status'
		for(int row = 0; row < currStatusGrid.length; row++){
			for(int col = 0; col < currStatusGrid[0].length; col ++){
				currStatusGrid[row][col].updateStatus(this.getNeighbors(row,col));
			}
		}
	}


	public void display(){
		for(int row = 0; row < currStatusGrid[0].length; row++){
			if(row != 0){
				System.out.print("\n");
			}
			for(int col = 0; col < currStatusGrid.length; col++){
				if(currStatusGrid[row][col].getStatus() == true){
					System.out.print("#");
				}
				else{
					System.out.print("-");
				}
				System.out.print(" ");
			}
		}
	}

	private void copyToTempGrid(){
		for(int row = 0; row < currStatusGrid.length; row++){
			for(int col = 0; col < currStatusGrid[0].length; col ++){
				tempStatusGrid[row][col].setStatus(currStatusGrid[row][col].getStatus());
			}
		}
	}


	/*  Returns the number of neighbors a cell has given its position in the grid.
		Will allow checking of potential neighbors to wrap around the grid if it is
		located on an edge*/
	private int getNeighbors(int currRow,int currCol){
        
        int tp = -1, bt = -1 , lf = -1, rt = -1;
        
        if(currRow == 0) tp = tempStatusGrid.length-1;
        else if(currRow == tempStatusGrid.length - 1) bt = 0;
        if(currCol == tempStatusGrid[0].length - 1) rt = 0;
        else if(currCol == 0) lf = tempStatusGrid[0].length - 1;
        
        if(tp == -1) tp = currRow - 1;
        if(bt == -1) bt = currRow + 1;
        if(rt == -1) rt = currCol + 1;
        if(lf == -1) lf = currCol -1;
        
        int numNeighbors = 0;
        if(tempStatusGrid[tp][currCol].getStatus() == true)
        	numNeighbors += 1;
        if(tempStatusGrid[bt][currCol].getStatus() == true)
        	numNeighbors += 1;
        if(tempStatusGrid[currRow][rt].getStatus() == true)
        	numNeighbors += 1;
        if(tempStatusGrid[currRow][lf].getStatus() == true)
        	numNeighbors += 1;
        if(tempStatusGrid[tp][lf].getStatus() == true)
        	numNeighbors += 1;
        if(tempStatusGrid[bt][lf].getStatus() == true)
        	numNeighbors += 1;
        if(tempStatusGrid[tp][rt].getStatus() == true)
        	numNeighbors += 1;
        if(tempStatusGrid[bt][rt].getStatus() == true)
        	numNeighbors += 1;
        
        return numNeighbors;

    }

	
}

