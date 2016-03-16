
public class Attendance {
	private int eventId;
	private String status;
private int memberId;


public Attendance(int eventId, String status, int memberId) {
	this.eventId = eventId;
	this.status = status;
	this.memberId = memberId;
}
@Override
public String toString() {
	return "Attendance [eventId=" + eventId + ", status=" + status + ", memberId=" + memberId + "]";
}
public int getMemberId() {
	return memberId;
}
public void setMemberId(int memberId) {
	this.memberId = memberId;
}
public int getEventId() {
	return eventId;
}
public void setEventId(int eventId) {
	this.eventId = eventId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

	
	
}
