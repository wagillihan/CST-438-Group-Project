package dw;

//import java.util.List;
import javax.persistence.*;

@Entity
public class Chore {
	
   // must have public fields or public getters/setters 
   @Id
   private Integer choreId;

   @Version
   private Integer version;

   private String choreName = "";
   private String choreDescription = "";
   private Integer chorePayout;
   private String dayOfWeek;
   private boolean isRecurring;
   private boolean isComplete;
   private boolean isConfirmed;
	
   // jpa Entity class must have a public no-arg constructor
	
   public Chore(){
   }
	
   public Chore(int id, String choreName, String choreDescription, int chorePayout, 
                String dayOfWeek, boolean isRecurring, boolean isComplete, boolean isConfirmed){
      choreId=id;
      this.choreName=choreName;
      this.choreDescription=choreDescription;
      this.chorePayout=chorePayout;
      this.dayOfWeek=dayOfWeek;
      this.isRecurring = isRecurring;
      this.isComplete = isComplete;
      this.isConfirmed = isConfirmed;
   }
	public void print(){
		System.out.println("ChoreID: "+choreId+"choreName:"+choreName+"choreDescription: "+choreDescription
                      +"chorePayout:"+chorePayout+"dayOfWeek: "+dayOfWeek+"isRecurring: "+isRecurring
                      +"isConfirmed: "+isConfirmed);
	}
	
	public int getChoreId() {
		return choreId;
	}

	public void setChoreId(int choreId) {
		this.choreId = choreId;
	}

	public String getChoreDescription() {
		return choreDescription;
	}

	public void setChoreDescription(String choreDescription) {
		this.choreDescription = choreDescription;
	}

	public int getChorePayout() {
		return chorePayout;
	}

	public void setChorePayout(int chorePayout) {
		this.chorePayout = chorePayout;
	}
  
 	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
  
  public boolean getIsRecurring() {
		return isRecurring;
	}

	public void setIsRecurring(boolean isRecurring) {
		this.isRecurring = isRecurring;
	}
  
	public boolean getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
  
  public boolean getIsConfirmed() {
		return isConfirmed;
	}

	public void setIsConfirmed(boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}
  
	@Override
	public String toString(){
		String r = ("ChoreID: "+choreId+"choreName:"+choreName+"choreDescription: "+choreDescription
                      +"chorePayout:"+chorePayout+"dayOfWeek: "+dayOfWeek+"isRecurring: "+isRecurring
                      +"isConfirmed: "+isConfirmed);
		
		return r;
	}
	
}
