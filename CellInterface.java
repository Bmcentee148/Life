/** *********************************************************
	<p>This is the interface for the class {@code Cell} and will
	define its basic functions and procedures. </p>

	@author Brian McEntee
	@version 7.10.14
*********************************************************** */

public interface CellInterface{

	/**
		<p>This procedure will set the status of the cell to 
		on or off depending on the given parameter.</p>

		@param newStatus If false the Cell will be set to 'off',
			if true the Cell will be set to 'on'.
	*/
	public void setStatus(boolean newStatus);

	



}