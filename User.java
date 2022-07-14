import java.util.ArrayList;

public class User implements java.io.Serializable{
	
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	
	public User(){
		
	}
	
	public User(String username, String password, String firstname, String lastname) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	//since both admin and student have to view all courses, it is under user
	public static void ViewAllCourses(ArrayList<CoursesEntry> Courses) {
		System.out.println("\nAll the courses offered");
	}
	
	//since both admin and student have logins, it is under user
	public static String[] login() {
		System.out.println("login");
		String [] array = new String[1];
		return array;
	}
	
}
