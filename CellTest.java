//Basic tests for the Cell routines

public class CellTest{

	public static void main(String [] args){

		Cell testCell_status = new Cell(); // test default constructor
		System.out.println(testCell_status.toString());

		testCell_status.setStatus(false);
		System.out.println(testCell_status.toString());

		testCell_status.updateStatus(3); //Cell should turn on
		System.out.println(testCell_status.toString());

	}
}