
public class UniversityEmail extends Email {

	String department;  //variables
	int code=0;
	String[] departments=  {"","art","chee","chem","coe","cs","egr","polsci"}; //array with departments
	
	public UniversityEmail() //email constructor
	{
		super();
	}
	
	public UniversityEmail(String username, String department,String domain, String extension) //constructor with arguments
	{
		super(username,domain,extension);
		this.department = department;
		
		for(int i=1;i<8;i++)
		{
			
			if(department.equals(departments[i]))
			{
				this.code=i;
			}
			
		}
		
	}
	public String toString() //converting output to string
	{
		return ( getUser()+"@"+getDepartment()+"."+getDomain()+"."+getExtension());
	}
	public String getDepartment() //get functions 
	{
		return department;
	}
	public int getCode()
	{
		return code;
	}
}
