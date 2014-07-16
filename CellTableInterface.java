/** ************************************************************
<p> This is the interface for {@code CellTable} and will define 
	its basic functions and procedures. It will be comprised of
	and depend on being formulated by {@code Cell} objects. </p>

	@author Brian McEntee
	@version 7.11.2014 12.21am

***************************************************************/

public interface CellTableInterface{

	/** <p> This procedure will initialize the CellTable. This
		method MUST be done before any new generations of the 
		table can be created. </p> 

		@param initialTable This will be the initial state of the 
			{@code CellTable}. All future generations will be based
			off of this initial state. */
	public void initialize(Cell [][] initialTable);

	/** <p> This procedure will bring about a new generation of the 
		game. The {@code cellGrid} will be changed based on the 
		number of neighbors that were turned 'on' for each 
		{@code Cell} in the {@code CellTable}.</p> */
	public void newGeneration();

	/** <p> This procedure will display the {@code CellTable}'s 
		current state. </p> */
	public void display();


}