package mycollege.person;

import java.time.LocalDate;

/** 
 * The Employee class is a subclass, deriving from it's parent/base class Person.
 * The Employee extends the Person class. 
 * 
 * @author Trystan Bennett
 * @version 1.0
 * @since 2021.03.02
*/
public class Employee extends Person {
	
	/**
	 * Default Person type is Person, but this should always get changes
	 * in the subclasses (child class / derived class).  It's final so it 
	 * can't be internally changed.
	 */
	final String type = "Employee";
	
	/**
	 * deductions give the W2 deduction information for that employee
	 */
	private int deductions;
	
	/**
	 * Specifies the department for an employee
	 */
	private String department;
	
	/**
	 * The Employee default constructor that calls the parent Person default constructor
	 */
	public Employee(){
		super();
	}
	
	/**
	 * Overload constructor that allows setting the object's default fields (attributes).
	 * Also sets the employee's default field (attribute) deductions equal to 0.
	 * 
	 * @param dateofbirth Default date of birth is null.
	 * @param gender Default gender is null.
	 */
	public Employee(LocalDate dateofbirth, Gender gender) {
		super(dateofbirth, gender);
		
	}
	
	/**
	 * Get the Person's type.  This parent's class method has to be 
	 * overridden in the subclass otherwise we would only see the parent's 
	 * class type value of Person, and instead we want it to return Employee.
	 */
	@Override // Whenever you override a method, you should use the @Override annotation so the compile verifies
	public String getType() {
		return this.type;
		
	}

	/**
	 * Get the employee's deductions.
	 * 
	 * @return The employee's deductions.
	 */
	public int getDeductions() {
		return this.deductions;
		
	}
	
	/**
	 * Get the employee's department.
	 * 
	 * @return The employee's department.
	 */
	public String getDepartment() {
		return this.department;
		
	}

	/**
	 * Set the employee's deductions.
	 * 
	 * @param deductions The employee's deductions
	 */
	public void setDeductions(int deductions) {
		
		if(deductions >= 0)
			this.deductions = deductions;
		else
			this.deductions = 0;
		
	}	
	
	/**
	 * Set the employee's department
	 * 
	 * @param department The employee's department
	 */
	public void setDepartment(String department) {
		this.department = department;
		
	}
	
	/**
	 * Employee's department
	 * 
	 * @return true if the employee has a department, otherwise return false
	 */
	public boolean noDepartment() {
		if (this.department == null)
			return true;
		else
			return false;
	}
	
}
