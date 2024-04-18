//Adam Vasquez
public class Student {
	//Initialize student attributes
	private int studentId;
	private String name;
	private int age;
	private String major;
	
	public Student(int studentId, String name, int age, String major) { //Creates constructor for Student class that initializes Student object
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.major = major;
	}
	
	public int getStudentId() { //Getter method for student ID
		return studentId;
	}
	
	public void setStudentId(int studentId) { //setter method for student ID
		this.studentId = studentId;
	}
	
	public String getName() { //Getter method for student name
		return name;
	}
	
	public void setName(String name) { //Setter method for student name
		this.name = name;
	}
	
	public int getAge() { //Getter method for student age
		return age;
	}
	
	public void setAge(int age) { //Setter method for student age
		this.age = age;
	}
	
	public String getMajor() { //Getter method for student major
		return major;
	}
	
	public void setMajor(String major) { //Setter method for student major
		this.major = major;
	}
	
	public String toString() { //toString method to display student name
        return name; 
    }
}
