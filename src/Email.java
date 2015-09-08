
public class Email {
	
	String username, domain, extension;//variables
	
	public Email()//email constructor
	{
	
	}
	
	public Email(String username, String domain, String extension)//constructor with arguments
	{
	this.username = username;
	this.domain = domain;
	this.extension = extension;
	}
	public String toString()//converting output to string
	{
		return (getUser()+"@"+getDomain()+"."+getExtension());
	}
	public String getUser() //get functions 
	{
		return username;
	}
	public String getDomain()
	{
		return domain;
	}
	public String getExtension()
	{
		return extension;
	}
	public int getCode()
	{
		return 0;
	}

}
