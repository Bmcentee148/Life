/** <p>This class will represent a Cell in Conway's game of life and
	will be either 'on' or 'off'. It will be responsible for 
	knowing its status, and being able to change this status.</p>

	@author Brian McEntee
	@version 7.16.2014 */

public class Cell implements CellInterface{

	private boolean status;

	public Cell(){
		this.status = false; //the default status will be 'off'
	}

	public Cell(boolean status){
		this.status = status;
	}

	public void setStatus(boolean newStatus){
		this.status = newStatus;
	}

	public boolean getStatus(){
		return this.status;
	}

	public void updateStatus(int numNeighborsOn){
		if(this.status == true){
			if(numNeighborsOn < 2 || numNeighborsOn > 3){
				this.setStatus(false);
			}
		}
		else if(this.status == false){
			if(numNeighborsOn == 3){
				this.setStatus(true);
			}
		}
	}

	@Override
	public String toString(){
		String r_str =  "" + this.status;
		return r_str;
	}
}