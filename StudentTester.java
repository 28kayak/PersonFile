//CIS255
//lab#2
//Kaya Ota
//StudentTester.java
//9,3,2012

public class StudentTester 
{

	public static void main(String[] args)
	{
		Student student1 = new Student();
		Student student2 = new Student();
		
		
		student1.setFirstName("Mickey");
		student1.setLastName("Mouse");
		student1.setStudentId(101);
		student1.setEmailAddress("mickey@disney.com");
		student1.setPhoneNumber("555-1212");
		
		System.out.println(student1.toString());
		
		student2.setFirstName("Minnie");
		student2.setLastName("Mouse");
		student2.setStudentId(102);
		student2.setEmailAddress("minnie@disney.com");
		student2.setPhoneNumber("555-1212");
		
		/*student2.setFirstName("Mickey");
		student2.setLastName("Mouse");
		student2.setStudentId(101);
		student2.setEmailAddress("mickey@disney.com");
		student2.setPhoneNumber("555-1212");
		*/
		
		System.out.println(student2.toString());
		
		if(student1.equals(student2))
		{
			System.out.printf("Student %d, Name %s is equls to Student %d, Name %s",
					student1.getStudentId(),student1.getLastName(),student2.getStudentId(),student2.getLastName());
		}
		else
		{
			System.out.printf("Student %d, Name %s is NOT equls to Student %d, Name %s",student1.getStudentId(),student1.getFirstName(),student2.getStudentId(),student2.getFirstName());
		}
		
		
	}

}
