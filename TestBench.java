package mycollege.testing; // keeping the testbench logic separate

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import mycollege.person.*; // the wildcard * will import all classes & interfaces

/** 
 * The TestBench class contains multiple unit testing methods for testing
 * the Person base (super or parent) and derived (sub or child) classes.
 * 
 * Since there should only be one TestBench running, all helper methods
 * are static.  We do not need to create a TestBench object to run the 
 * individual unit testing methods (helper methods).  
 * 
 * No other class needs to access the helper methods so all the unit testing
 * methods are defined as private. 
 * 
 * @author Trystan Bennett
 * @version 1.0
 * @since 2021.02.26 
 */
public class TestBench {
	
	/**
	 * Stores all types of my college persons as long as it's a derived from the Person class.
	 */
	private static List<Person> myCollegePeople = new ArrayList<>();
	
	/**
	 * The default constructor currently isn't needed.
	 */
	TestBench(){
	}
	
	/**
	 * Unit test instantiation of a Person reference variable (object)
	 * using the default constructor
	 */
	private static void unitTest1_Person_Default() {
		
		System.out.println();
		System.out.println("Start of " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println();

		//create a person instance (object) using default constructor
		Person person = new Person();

		myCollegePeople.add(person);
		
		displayInfo(person);
		
		person.setDateOfBirth(LocalDate.of(2003, 03, 04));
		person.setGender(Gender.MALE);
		
		displayInfo(person);	

	}
	
	/**
	 * Unit test instantiation of a Person reference variable (object)
	 * using the overload constructor
	 */
	private static void unitTest2_Person_Overload() {	
		
		System.out.println();
		System.out.println("Start of " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println();
		
		//create another person instance (object) using overload constructor		
		Person person = new Person(LocalDate.of(2003, 03, 05), Gender.FEMALE);
		
		myCollegePeople.add(person);
		
		displayInfo(person);

	}
	
	/**
	 * Unit test instantiation of a student's reference variable (object)
	 * using the default constructor
	 */
	private static void unitTest3_Student_Default() {
		
		System.out.println();
		System.out.println("Start of " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println();

		//create a student instance (object) using default constructor
		Student student = new Student();

		myCollegePeople.add(student);
		
		displayInfo(student);
		
		if (student.noMajor())
			System.out.println("IMPORTANT: This student has not declared a major yet.");
		else
			System.out.println("This student's major is " + student.getMajor());
		
		System.out.println("This student is a " + student.getAcademicLevel());
		System.out.println();
		
		student.setDateOfBirth(LocalDate.of(2000, 7, 20));
		student.setGender(Gender.FEMALE);
		student.setMajor("wow");
		student.setAcademicLevel(AcademicLevel.Sophomore);
		
		displayInfo(student);
		
		if (student.noMajor())
			System.out.println("IMPORTANT: This student has not declared a major yet.");
		else
			System.out.println("This student's major is " + student.getMajor());
		
		System.out.println("This student is a " + student.getAcademicLevel());
		System.out.println();

	}
	
	/**
	 * Unit test instantiation of an Employee's reference variable (object)
	 * using the overload constructor
	 */
	private static void unitTest4_Employee_Overload() {
		
		System.out.println();
		System.out.println("Start of " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println();
		
		//create another employee instance (object) using overload constructor		
		Employee employee = new Employee(LocalDate.of(1990, 02, 24), Gender.FEMALE);
		myCollegePeople.add(employee);
		
		displayInfo(employee);
		
		if (employee.noDepartment())
			System.out.println("IMPORTANT: This employee has not been assigned a department.");
		else
			System.out.println("This employee's department is " + employee.getDepartment());
		
		System.out.println("Employee W2 Deductions: " + employee.getDeductions());
		System.out.println();
		
		displayInfo(employee);
		
		employee.setDepartment("Mathematics");
		employee.setDeductions(1000);
		
		if (employee.noDepartment())
			System.out.println("IMPORTANT: This employee has not been assigned a department.");
		else
			System.out.println("This employee's department is " + employee.getDepartment());
		
		System.out.println("Employee W2 Deductions: " + employee.getDeductions());
		System.out.println();
		
	}
	
	/**
	 * Unit test of inputing invalid data
	 */
	private static void unitTest5_Invalid_Data() {
		
		System.out.println();
		System.out.println("Start of " + Thread.currentThread().getStackTrace()[1].getMethodName());
		System.out.println();
		
		//create another employee instance (object) using overload constructor		
		Employee employee = new Employee(LocalDate.of(1990, 02, 24), Gender.FEMALE);
		
		myCollegePeople.add(employee);
		
		employee.setDateOfBirth(LocalDate.of(197, 3, 31));
		employee.setGender(Gender.MALE);
		employee.setDeductions(-5);
		
		displayInfo(employee);
		
		System.out.println("Employee W2 Deductions: " + employee.getDeductions());

	}
	
	/**
	 * Display the Person reference variable's id, type, gender, date of birth
	 * 
	 * @param person the reference variable data to be displayed
	 */
	private static void displayInfo(Person person) {
		
		System.out.printf("ID: %-3d  Type: %-10s  Gender: %-6s  DOB: %-10s  Minor: %-5s\n",
				person.getId(), person.getType(), person.getGender(), person.getDateOfBirth(), person.isMinor());
		
	} // end of displayInfo

	/**
	 * Display all MyCollege Persons stored in the ArrayList.
	 * It will display the id, type, gender, date of birth, and minor
	 */
	private static void displayReport() {
		
		System.out.println();
		System.out.println("========== MY COLLEGE REPORT =========");
		System.out.println("ID  Type       Gender DOB        Minor");
		System.out.println("=== ========== ====== ========== =====");
		
		for (Person person : myCollegePeople) {
			System.out.printf("%-3d %-10s %-6s %10s %-5s\n",
					person.getId(), person.getType(), person.getGender(), person.getDateOfBirth(), person.isMinor());
		}
		
		System.out.println();
		
	} // end of displayReport method
	
	/**
	 * The testbench to regression test that the Person base and subclasses are
	 * working correctly.
	 * 
	 * @param args this program doesn't use command line input arguments
	 */
	public static void main(String[] args) {
		
		TestBench.unitTest1_Person_Default();
		TestBench.unitTest2_Person_Overload();
		TestBench.unitTest3_Student_Default();
		TestBench.unitTest4_Employee_Overload();
		TestBench.unitTest5_Invalid_Data();
		
		TestBench.displayReport();
		
	}  // end of main method

} // end of Main class