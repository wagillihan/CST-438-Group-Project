package dw;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Parent 
{
	
	// must have public fields or public getters/setters 
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int parentId; // auto generated sql
	private String parentName;
   
	private String email="";
	private String password="";
	
	@OneToMany (mappedBy = "parent", cascade=CascadeType.ALL)
	private List<Child> children;
	
	// jpa Entity class must have a public no-arg constructor
	
	public Parent()
   {
	}
	
	public Parent(int id, String name, String email, String password)
   {
      this.parentId = id;
		this.parentName = name;
		this.email = email;
		this.password = password;
		children = new ArrayList<Child>();
	}
	
	public void print()
   {
		System.out.println("Parent ID: " + parentId + ", Parent Name: " +
            parentName + ", Email:" + email + ", Password: " + password);
		System.out.println("children: " + children);
	}
	
	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Child> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Child> children) {
		this.children = children;
	}
	
	@Override
	public String toString(){
		String rtn = "[Parent Name: " + parentName + ", Email:" + email +
            ", Password: " + password +" children:[";
		for (Child child : getChildren()) {
			rtn = rtn + child.toString()+" ";
		}
		rtn = rtn + "]]";
		
		return rtn;
	}
	
}