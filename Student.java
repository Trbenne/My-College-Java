package mycollege.person;

import java.time.LocalDate;

/*  
 * The Student class is a subclass, deriving from it's parent/base class Person.
 * The Student extends the Person class. 
 * 
 * @author Trystan Bennett
 * @version 1.0
 * @since 2021.03.02
*/
public class Student extends Person {

	final String type = "Student";
	
	private AcademicLevel academicLevel;
	
	private String major = "Undeclared";
		
	// default constructor
	public Student(){
		/* Default date of birth is null.
		 * Default gender is null.
		 */
		this(null, null); // dateofbirth, gender
	}
	
	/**
	 * Overload constructor that allows setting the object's default fields (attributes).
	 * 
	 * @param dateofbirth Default date of birth is null.
	 * @param gender Default gender is null.
	 */
	public Student(LocalDate dateofbirth, Gender gender) {
		super(dateofbirth, gender);
	}
	
	/**
	 * Get the Person's type.  This parent's class method has to be 
	 * overridden in the subclass otherwise we would only see the parent's 
	 * class type value of Person, and instead we want it to return Student.
	 */
	@Override // Whenever you override a method, you should use the @Override annotation so the compile verifies	
	public String getType() {
		return this.type;
	}
	
	/**
	 * Get the student's academic level (enum: Freshman, Sophomore, Junior, or Senior).
	 * We do not need to validate Academic Level because we are using an enum
	 * 
	 * @return The student's academic level
	 */
	public AcademicLevel getAcademicLevel() {
		return this.academicLevel;
	}
	
	/**
	 * Get the student's major.
	 * 
	 * @return The student's major
	 */
	public String getMajor() {
		return this.major;
	}

	/**
	 * Set the student's academic level type.
	 * 
	 * @param academicLevel The student Academic Level type (enum: Freshman, Sophomore, Junior, or Senior).
	 */
	public void setAcademicLevel(AcademicLevel academicLevel) {
		this.academicLevel = academicLevel;
	}	
	
	/**
	 * Set the student's major
	 * 
	 * @param major The student's major
	 */
	public void setMajor(String major) {
		this.major = major;
	}

	/**
	 * Student's major (behavior)
	 * @return true if the student has a major, otherwise return false
	 */
	public boolean noMajor() {
		if (major == "Undeclared")
			return true;
		else
			return false;
	}
	
}