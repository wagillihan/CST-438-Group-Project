package dw;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Child 
{	
	// fields must be public or public getters/setters 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer childId;  // auto generated sql
	
	private String childName = "";
	private String childUsername = "";
	private Date birthDate = null;
	private String childPassword = "";
	private double currentBalance;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="parentid")
	// note: there are no public getters/setter for this field to prevent infinite recursion 
	//  when converting Child to JSON
	private Parent parent;	
	// jpa Entity class must have a public no-arg constructor	
	public Child()
   {
	}
	
	public Child(String name, String usrName, Date date, String password, double balance)
   {
		this.childName = name;
		this.childUsername = usrName;
		this.birthDate = date;
		this.childPassword = password;
		this.currentBalance = balance;
	}
	
	@Override
	public String toString()
   {
		return "[Child Name: " + childName + ", Child Username: " + childUsername +
            " birthDate: " + birthDate + " Password: " + childPassword +
            "current Balance" + currentBalance + "]";
	}
	
	public Integer getChildId() 
   {
		return childId;
	}
   
	public void setChildId(Integer childId) 
   {
		this.childId = childId;
	}
   
	public String getChildName() 
   {
		return childName;
	}

	public void setChildName(String childName) 
   {
		this.childName = childName;
	}

	public String getChildUsername() 
   {
		return childUsername;
	}

	public void setChildUsername(String childUsername) 
   {
		this.childUsername = childUsername;
	}

	public Date getBirthDate() 
   {
		return birthDate; 
	}

	public void setBirthDate(Date birthDate) 
   {
		this.birthDate = birthDate;
	}
   
   public String getChildPassword() 
   {
		return childPassword; 
	}

	public void setChildPassword(String password) 
   {
		this.childPassword = password;
	}
   
   public double getCurrentBalance() 
   {
		return currentBalance; 
	}

	public void setCurrentBalance(Double balance) 
   {
		this.currentBalance = balance;
	}
	
	public void verifyParent(Parent p) 
   {
		// the purpose of this method is to verify and fix bi-directional relations
		// JSON does not handle bi-directional relationships, so when objects 
		// are sent from client to server, we need to fix this up before writing to database
		if (this.parent != p) 
      {
			this.parent = p;
		}		
	}
}