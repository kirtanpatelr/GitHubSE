
public class Member {
	private int ID;
	private String fullName;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	@Override
	public String toString() {
		return "Member [ID=" + ID + ", fullName=" + fullName + "]";
	}
	public Member(int iD, String fullName) {
		ID = iD;
		this.fullName = fullName;
	}
}
