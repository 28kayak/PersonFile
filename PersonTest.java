import java.util.Scanner;


public class PersonTest 
{


	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		
		/*for (int i=0;i<3;i++)
        {
                boolean result = Person.read(i);
                if (result)
                {
                        System.out.printf("Record exists: %d\n",i);
                }       else
                {
                        System.out.printf("Record not exists: %d\n",i);
          
                }
        }//for
		*/
		String firstname="";
		String lastname ="";
		String emailAdd="";
		String phone = "";
		System.out.println("Type end when you finish typing personal information");
		
		boolean toEnd = true;
		String teminate = "end";
		do
		{
			System.out.println("Type Fist Name ");
			firstname  = input.nextLine();
			if(!firstname.equalsIgnoreCase(teminate))
			{	
				System.out.println("Type Last Name");
				lastname = input.nextLine();
				System.out.println("Type Email Address");
				emailAdd = input.nextLine();
				System.out.println("Type Phone Number");
				phone = input.nextLine();
			
				System.out.println("\nfirst name");
				System.out.println(firstname);
				System.out.println("lastname");
				System.out.println(lastname);
				System.out.println("EmailAddress");
				System.out.println(emailAdd);
				System.out.println("\nphone");
				System.out.println(phone);
				
				Person person = new Person(firstname,lastname,emailAdd,phone);
				person.save();
			}
			else
			{
				toEnd = false;
			}
			
		}while(toEnd == true);//do
		
		Person.listAll();
		System.out.println("type an ID number to access infotmation");
	 	int personalId = input.nextInt();
		Person.read(personalId);
		System.out.println("\nthis program is teminated ");

	}//main

}//class
