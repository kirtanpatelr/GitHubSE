import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ArrayList;

public class Database {

	private static Connection getMSAccessConnection()
	{
		Connection conn = null;

		try { 
			String url1="jdbc:mysql://www.db4free.net:3306/csci4320";
			String  user="csci4320";
			String password ="ThankYou";
			
			url1 =  "jdbc:ucanaccess://Users/gita.phelps/Documents/workspace/OnlineDatabaseTest/bin/AttendanceDatabase.accdb";
			url1 =  "jdbc:ucanaccess://Users/AttendanceDatabase.accdb";
			
			user ="";
			password="";
			conn = DriverManager.getConnection(url1, user, password);
		}
		catch (SQLException ex) {
			System.out.println("An error occurred. ");
			ex.printStackTrace();
		}
		return conn;
	}
	private static Connection getConnection()
	{
		Connection conn = null;

		try { 
			String url1="jdbc:mysql://www.db4free.net:3306/csci4320";
			String  user="csci4320";
			String password ="ThankYou";
			conn = DriverManager.getConnection(url1, user, password);
		}
		catch (SQLException ex) {
			System.out.println("An error occurred. ");
			ex.printStackTrace();
		}
		return conn;
	} 
	
	
	private static ResultSet runQuery(String query)
	{
		ResultSet rs = null;
		Connection conn = null;
		try { 
			 conn = getConnection();
			if (conn != null) {
				Statement stmt = conn.createStatement();
				rs = stmt.executeQuery(query);
				return rs;
			}
			conn.close();
		}
		catch (SQLException e)
		{
			return null;
		}
		return rs;
	}

	public static ArrayList<Member> getMembers()
	{
		ArrayList<Member> result = new ArrayList<Member>();

		try
		{
			ResultSet rs = runQuery("SELECT * FROM Member");
			while (rs.next() ) {
				String fullName = rs.getString("fullName");
				String id = rs.getString("id");
				//System.out.println("id: " + id + "\tfullName: " +fullName);
				result.add( new Member(Integer.parseInt(id),fullName));
			}
		} catch (SQLException ex) {
			System.out.println("An error occurred. ");
			ex.printStackTrace();
		}

		return result;
	}
	
	public static ArrayList<Event> getEvent()
	{
		ArrayList<Event> result = new ArrayList<Event>();

		try
		{
			ResultSet rs = runQuery("SELECT * FROM Event");
			while (rs.next() ) {
				String eid = rs.getString("EID");
				String description = rs.getString("Description");
				String date = rs.getString("EDate");
				//System.out.println("eid: " + eid + "\tdescription: " +description + " \tedate:" + date);
				result.add( new Event(Integer.parseInt(eid),description, date));
			}
		} catch (SQLException ex) {
			System.out.println("An error occurred. ");
			ex.printStackTrace();
		}

		return result;
	}
	
	public static ArrayList<Attendance> getAttendance()
	{
		ArrayList<Attendance> result = new ArrayList<Attendance>();

		try
		{
			ResultSet rs = runQuery("SELECT * FROM Attendance");
			while (rs.next() ) {
				String eventId = rs.getString("EventId");
				String memberId = rs.getString("MemberId");
				String status = rs.getString("Status");
				
				result.add( new Attendance(Integer.parseInt(eventId), status, Integer.parseInt(memberId)));
			}
		} catch (SQLException ex) {
			System.out.println("An error occurred. ");
			ex.printStackTrace();
		}

		return result;
	}
	
	public static ArrayList<String> getSummary()
	{
		ArrayList<String> result = new ArrayList<String>();

		try
		{
			String fields ="SELECT Member.FullName, Attendance.MemberId, Attendance.EventId, Attendance.Status, Event.EDate ";
			String tables = "FROM Attendance INNER JOIN Event ON Attendance.EventID=Event.EID  INNER JOIN Member ON Attendance.MemberID=Member.ID ";
			String groupby = " GROUP BY Member.FullName";
					
		   String query = fields + tables + groupby;
		   
		   query = "SELECT DISTINCT Event.EDate from Event";
		   
		   
			ResultSet rs = runQuery(query);
			while (rs.next() ) {
				//System.out.println(rs.toString());
			//	String eventId = rs.getString("EventId");
				//String memberId = rs.getString("MemberId");
				//String status = rs.getString("Status");
				String edate = rs.getString("EDate");
				//String fullName = rs.getString("FullName");
				
				
				//result.add( new String(eventId+"#"+memberId+"#"+status +"#"+edate+"#"+fullName));
				result.add(new String(edate));
			}
		} catch (SQLException ex) {
			System.out.println("An error occurred. ");
			ex.printStackTrace();
		}

		return result;
	}
	
	
/*	public static void main(String[] args) {
		ArrayList<String> list = getSummary();
		for (String  m: list)
		{
			System.out.println(m);
		}
		
	}
*/


}
