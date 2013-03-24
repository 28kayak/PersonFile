//CIS255
//lab#2
//Kaya Ota
//Student.java
//9,3,2012


public class Student extends Person 
{
	
	private int studentId;
	//private String lastName = super.getLastName();
	
	public void setStudentId(int id)
	{
		studentId = id;
	}
	public int getStudentId()
	{
		return studentId;
	}
	public String toString()
	{
		//String.valueOf(studentId);
		return String.format("%s:%s:%s:%s:%s" ,String.valueOf(studentId),getLastName(),getFirstName(),getEmailAddress(),getPhoneNumber() );
		
	}
	public boolean equals(Student student)
	{
		// also if(student.getStudentId() == this.getStudentId())
		if(student.getStudentId() == this.studentId)
		{
			if(student.getLastName() == this.getLastName())
			{
				if(student.getFirstName() == this.getFirstName())
				{
					if(student.getEmailAddress() == this.getEmailAddress())
					{
						if(student.getPhoneNumber() == this.getPhoneNumber())
						{
							return true;
						}
					}
				}
			}
		}
		else
		{
			return false;
		}
	
	    return false;
	
	}	//equals 
		
	
	
}//class





