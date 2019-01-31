package cmput402.mocking;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import service.City;
import service.Salary;
import stub.CityStub;
import stub.SalaryStub;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public static void testCaptilizeName()
    {
    	assert("Abram Hindle".equals(
    			Main.captilizeName("abram hindle")));
    }
    
    public static void testFilterEdmonton()
    {
    	Util util = new Util();
    	CityStub stub = new CityStub();
    	assert(util.filterEdmonton(stub) == 3);
    }
    
    public static void testCountSalaries()
    {
    	Util util = new Util();
    	SalaryStub stub = new SalaryStub();
    	assert(util.countSalaries(stub) == 2);
    }
    
    public static void testFilterEdmontonMockito()
    {
    	Util util = new Util();
    	
    	City mockCity = mock(City.class);
    	List<String> listCities = new ArrayList<String>();
    	listCities.add("Edmonton");
    	listCities.add("Calgary");
    	listCities.add("Edmonton");
    	listCities.add("Calgary");
    	
    	List<String> listCities2 = new ArrayList<String>();
    	listCities2.add("Calgary");
    	listCities2.add("Edmonton");
    	listCities2.add("Calgary");
    	
    	when(mockCity.listCities()).thenReturn(listCities).thenReturn(listCities2);
    	assert(util.filterEdmonton(mockCity) == 2);
    	assert(util.filterEdmonton(mockCity) == 1);

    	verify(mockCity, times(2)).listCities();

    }
    
    public static void testCountSalariesMockito()
    {
    	Util util = new Util();
    	
    	Salary mockSalary = mock(Salary.class);
		ArrayList<Integer> salaries = new ArrayList<Integer>();
		salaries.add(25000);
		salaries.add(52000);
		salaries.add(125000);
		
		ArrayList<Integer> salaries2 = new ArrayList<Integer>();
		salaries2.add(99000);
		salaries2.add(250000);
		salaries2.add(75000);
		
    	when(mockSalary.returnSalaries()).thenReturn(salaries).thenReturn(salaries2);
    	assert(util.countSalaries(mockSalary) == 2);
    	assert(util.countSalaries(mockSalary) == 3);

    	verify(mockSalary, times(2)).returnSalaries();
    }
}
