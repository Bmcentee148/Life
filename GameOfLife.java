/** This will simulate Conway's Game Of Life. It will be given an initial
	state and a number of generations and will then display the resulting 
	output at the end of the generations. 

	@author Brian McEntee
	@version 7.16.2014 */

import java.io.*;
import java.util.Scanner;
public class GameOfLife{
	
	public static int numGens;
	
	public static void main(String [] args){
		
		String fileName = "";
		CellTable gameBoard = null;

		//capture name of file from command line arg or terminate
		if(args.length != 0){
			fileName = args[0];
		}
		else{
			System.err.println("No command line arguments");
			System.exit(1);
		}

		try{
			gameBoard = new CellTable(getStateFromFile(fileName)); //create the board
		}
		catch(IOException e){
			System.out.println(e.toString());
		}

		gameBoard.display(); //display initial state
		System.out.println("\n");

		//run through each generation 
		for(int i = 0; i< numGens; i++){
			gameBoard.newGeneration();
		} 
		gameBoard.display(); //display final state
	}

	private static Cell[][] getStateFromFile(String fileName) throws IOException{
		Cell[][] initArray;
		File file = new File(fileName);
		String tempLine;
		char currChar;

		Scanner inputFile = new Scanner(file);

		

		numGens = inputFile.nextInt();
		int numRows = inputFile.nextInt();
		int numCols = inputFile.nextInt();
		inputFile.nextLine();
		initArray = new Cell[numRows][numCols];
		
			
		for(int i = 0; i < numRows; i++){
			tempLine = inputFile.nextLine();
			for (int j = 0; j< numCols; j++){
					Cell newCell = new Cell();
					initArray[i][j] = newCell;
					currChar = tempLine.charAt(j);
					String charString = Character.toString(currChar);
					if(charString.equals("#")){
						initArray[i][j].setStatus(true);
					}
					else{
						initArray[i][j].setStatus(false);
					}
				}
			
		}
		inputFile.close();
		return initArray;
		
	}
}