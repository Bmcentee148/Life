/** ************************************************************
	<p>This is the interface for the class {@code Cell} and will
	define its basic functions and procedures. </p>

	@author Brian McEntee
	@version 7.10.14 12.21am
*****************************************************************/

public interface CellInterface{

	/** <p> This procedure will set the status of the cell to 
		on or off.</p>

	@param newStatus If false the Cell will be set to 'off',
		if true the Cell will be set to 'on'. */
	public void setStatus(boolean newStatus);

	/** <p>This function will return whether the {@code Cell}
		object is 'on' or 'off'.</p>

	@return status The current status of the object. True is 
		defined as 'on' and false 'off.  */
	public boolean getStatus();

	/** <p> This procedure will update the status of the 
		{@code Cell} object based on the number of neighbors it 
		has that are turned 'on'.</p>

		@param numNeighborsOn the number of neighbors a {@code Cell} 
		object has that are turned 'on'. */
	public void updateStatus(int numNeighborsOn);

}