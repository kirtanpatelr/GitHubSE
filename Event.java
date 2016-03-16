
public class Event {
	private int EID;
	private String description;
	private String EDate;
	
	public Event(int eID, String description, String eDate) {
		EID = eID;
		this.description = description;
		EDate = eDate;
	}
	@Override
	public String toString() {
		return "Event [EID=" + EID + ", description=" + description + ", EDate=" + EDate + "]";
	}
	public int getEID() {
		return EID;
	}
	public void setEID(int eID) {
		EID = eID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEDate() {
		return EDate;
	}
	public void setEDate(String eDate) {
		EDate = eDate;
	}

	

}
