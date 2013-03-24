
//CIS255
//lab#2
//Kaya Ota
//Peson.java
//8,27,2012

public class Person
{

	private String lastName; 
	private String firstName; 
	private String emailAddress;
	private String phoneNumber; 
	
	public Person()
	{
		lastName = " ";
		firstName = " ";
		emailAddress = " ";
		phoneNumber = " ";
		
	}
	
	public void setLastName(String ln)
	{
		lastName = ln; // Substitution Right to Left
		               // opposite does not work.
	}
	
	public void setFirstName(String fn)
	{
		firstName = fn;
	}
	public void setEmailAddress(String e)
	{
		emailAddress = e;
	}
	public void setPhoneNumber(String p)
	{
		phoneNumber = p;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getEmailAddress()
	{
		return emailAddress;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
}//class
