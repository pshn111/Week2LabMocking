package cmput402.mocking;

import java.util.List;
import service.City;
import service.Salary;

public class Util {
	
	public int filterEdmonton(City city)
	{
		int cityCount = 0;
		List<String> cities = city.listCities();
		for(String aCity: cities)
		{
			if(aCity.equals("Edmonton"))
			{
				cityCount++;
			}
		}
		
		return cityCount;
	}
	
	public int countSalaries(Salary salary)
	{
		int salaryCount = 0;
		List<Integer> salaries = salary.returnSalaries();
		for(Integer aSalary: salaries)
		{
			if(aSalary > 50000)
			{
				salaryCount++;
			}
		}
		
		return salaryCount;
	}

}
