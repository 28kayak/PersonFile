import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;


public class Person 
{
	private String lastName;
	private String firstName;
	private String emailAddress;
	private String phoneNumber;
	private int id;
	
	public Person(String fn, String ln, String e, String p)
	{
		firstName = fn;
		lastName = ln;
		emailAddress = e;
		phoneNumber = p;
		
		try
		{
			//open id.txt File 
			Scanner input = new Scanner(new File("id.txt"));
			//read id.txt File 
			int maxId = input.nextInt();
			id  = maxId+1;
			// close 
			input.close();
			Formatter outId = new Formatter("id.txt");
			outId.format("%d", id);
			outId.close();
			
		}//try
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			
		}
		
	}//Person1
	public Person(int idNum, String fn, String ln, String e, String p)
	{
		id = idNum;
		firstName = fn;
		lastName =ln;
		emailAddress = e;
		phoneNumber = p;
	}//previous one with id
	
	public void setLastName(String ln)
	{
		lastName = ln;
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
	public void setId(int idNum)
	{
		id = idNum;
	}
	//get methods 
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
	public int getId()
	{
		return id;
	}
	public boolean save()
	{
		try
		{
			BufferedWriter writer = new BufferedWriter( new FileWriter("person.txt", true));
			String information = String.format("%d %10s %10s %10s %10s", id, firstName,lastName, emailAddress, phoneNumber);
			//String rawdata = String.format("%s:%s:%s:%s:%d", getFirstName(), getLastName(),getEmailAddress(),getPhoneNumber(), getId());
			writer.write(information);
			writer.newLine();
			writer.close();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}
		return true;
	}//save()
	
	public static boolean read(int id)
	{
		boolean result = false;
		int idnum;
		
		try
		{
			Scanner pinput = new Scanner(new File("person.txt"));
			Scanner idOut = new Scanner(new File("id.txt"));
			int maxId = idOut.nextInt();
			if(id > maxId || id < -1)
			{
				System.out.println("invalid number");
				return false;
			}
			while(pinput.hasNext())
			{
				idnum = pinput.nextInt();
				String fname = pinput.next();
				String lname = pinput.next();
				String mail = pinput.next();
				String phone = pinput.next();
				
				if(idnum == id)
				{
					System.out.printf("ID: %d \nFirst: %10s \nLast:%10s \nEmail: %10s \nPhone#:%10s",idnum, fname, lname,mail,phone);
					result = true;
				}//if
				
			}//while
		}catch(FileNotFoundException ex1)
		{
			System.out.println(ex1.getMessage());
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return result; 
	}//read
	
		
		public static void listAll()
		{
			//System.out.println("main");
			Database db = new Database(MYSQL5, "localhost", "test", "mysql", "mysql");

			db.query("SELECT * FROM Person");
			try
			{
				ResultSet rs = db.getResultSet("SELECT * FROM Person");
				while(rs.next())
				{	
					System.out.printf("id: %d  firstname: %s   lastname : %s\n", 
						rs.getInt(1), rs.getString(2), rs.getString(3));
				}
		
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	
}

	
	
	
	
	
	
}//class
