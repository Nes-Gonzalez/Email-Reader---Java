
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JOptionPane; // all improts

public class Main {
	public static void main (String args[]) throws FileNotFoundException 
	{
		Scanner FileIN = null;
		FileIN = new Scanner (new FileInputStream ("inputemails.txt")); //Opening files
		PrintWriter FileOut = null;
		FileOut = new PrintWriter (new FileOutputStream ("outputemails.txt"));
		
		int EmailCounter=0;
		Email Emailarray[]= new Email[20];  // array for emails
		String user; 
		String dom; //variables used for holding and sorting emails
		String exten;
		String depart;
		String Line;
		int periodCounter;
		int userInput;
		
		while(FileIN.hasNext()) //main while loop
		{
			user = "";
			dom= "";
			exten = "";
			depart = "";
			Line = FileIN.next();
			if(Line.contains("@"))  //Looking for @ in emails
			{
				int[] periodPlace= new int[2];  //finding periods
				periodCounter=0;
				
				for(int i=0; i < Line.length();i++)
				{
				
					if(Line.charAt(i) == '.')
					{ 
						periodPlace[periodCounter]=i;
						periodCounter++;
						
					}
						
				}
				
				int CharCounter;
				for(CharCounter=0;CharCounter<Line.indexOf("@");CharCounter++) // reading user name
				{
					user += Line.charAt(CharCounter);
				}
				
				CharCounter++;	

				if(periodCounter==1)  //inputing rest of info for emails without department
				{


					 while(CharCounter!=periodPlace[0])
					{
					
						dom+= Line.charAt(CharCounter);
						CharCounter++;
					}
					CharCounter++;
					while(CharCounter!=Line.length())
					{
						if(Line.charAt(CharCounter)==',')
						{
							break;
						}
						 exten+=Line.charAt(CharCounter);
						 CharCounter++;
					}
					Emailarray[EmailCounter] = new Email(user,dom,exten);
					EmailCounter++;
					
				}
				if(periodCounter==2)//inputing rest of info for emails with department
				{
					while(CharCounter!=periodPlace[0])
					{
						depart+= Line.charAt(CharCounter);
						CharCounter++;
					}
					CharCounter++;
					while(CharCounter!=periodPlace[1])
					{
						 dom+=Line.charAt(CharCounter);
						 CharCounter++;
					}
					CharCounter++;
					while(CharCounter!=Line.length())
					{
						if(Line.charAt(CharCounter)==',')
							break;
						exten+=Line.charAt(CharCounter);
						CharCounter++;
					}
					Emailarray[EmailCounter] = new UniversityEmail(user,depart,dom,exten);  //creating email object into array
					EmailCounter++;
				
				}
			}
			
		}
		
		System.out.println("All emails in the file are\n");  //printing ALL emails to console
		for(int i=0;i<EmailCounter;i++)
		{
			System.out.println(Emailarray[i].toString());
		}
		
		userInput = Integer.parseInt(JOptionPane.showInputDialog("Please select department email you would like by entering the correspoinding department code 1 through 7.\n"
				+ "Enter 0 for emails not assigned to a department. (only enter a single integer, see console for complete list)"));
		 //message pane to catch User input
		
		int outputCounter=0;
		
		for(int i =0; i<EmailCounter;i++)  //finding how many emails are given department
		{
			if(userInput == Emailarray[i].getCode())
			{
				outputCounter++;
			}
		}
		FileOut.println(outputCounter+" emails for this department\n"); //printing out department emails
		for(int i =0; i<EmailCounter;i++)
		{
			if(userInput == Emailarray[i].getCode())
			{
				FileOut.println(Emailarray[i].toString());
			}
		}
	
		
		
		FileIN.close( ); //closing files
		FileOut.close();
	}
	
}
