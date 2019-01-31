package stub;

import java.util.ArrayList;

import service.Salary;

public class SalaryStub implements Salary {

	public ArrayList<Integer> returnSalaries() {
		ArrayList<Integer> salaries = new ArrayList<Integer>();
		salaries.add(25000);
		salaries.add(52000);
		salaries.add(125000);
		return salaries;
	}

}
