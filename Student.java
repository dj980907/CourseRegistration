import java.util.*;

public class Student extends User implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	//variables
	private String firstname;
	private String lastname;
	private String fullname;
	private String username;
	private String password;
	private ArrayList<String> Courses;
	
	//default constructor
	public Student() {
		
	}
	
	//constructor that take in parameters
	public Student(String firstname, String lastname, String username, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.fullname = firstname + " " + lastname;
		this.username = username;
		this.password = password;
		this.Courses = new ArrayList<String>();
//		this.Courses = new ArrayList<CoursesEntry>();
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
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public ArrayList<String> getCourses() {
		return Courses;
	}

	public void addCourses(String courses) {
		Courses.add(courses);
	}
	
	public void deleteCourses(String courses) {
		Courses.remove(courses);
	}
	
	public static Scanner input = new Scanner(System.in);
	
	public static String[] login() {
		System.out.println("Login");
		
		System.out.print("\nUsername: ");
		String username = input.nextLine();
		
		System.out.print("\nPassword: ");
		String password = input.nextLine();
		
		String[] loginInfo = new String[] {username, password};
		
		return loginInfo;
	}
	
	public static void ViewAllCourses(ArrayList<CoursesEntry> Courses) {
		System.out.println("\nAll the courses offered: student version");
		for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
			if (Courses.get(i).getCourseName() != "") {
				Courses.get(i).printCourseInfo();
			}
		}
	}
	
	//take in arraylist as a parameter and search for not full course
	public static void ViewAllNotFullCourses(ArrayList<CoursesEntry> Courses) {
		
		ArrayList<CoursesEntry> NotFullCourses = new ArrayList<>();
		
		for(int k = 0; k < Courses.size(); k++) {
			if (Courses.get(k).getCurrentStudent() < Courses.get(k).getMaxStudent()) {
				NotFullCourses.add(Courses.get(k));
			}
		}
		
		System.out.println("\nThese are courses that are full!");
		System.out.println("--------------------------------------------------");

		
		for (int i = 0; i < NotFullCourses.size() && NotFullCourses.get(i) != null; i++) {
			if (NotFullCourses.get(i).getCourseName()!= "") {
				NotFullCourses.get(i).printCourseInfo();
			}
		}
	}
	
	//take in arraylists as parameters and make changes to both lists
	//add student name under course
	//add course name under student
	public static void register(ArrayList<CoursesEntry> Courses, ArrayList<Student> student, String fullName) {
		
		System.out.println("What is the course name you want to register: ");
		String courseName = input.nextLine();
		System.out.println("What is the section number: ");
		int sectionNumber = input.nextInt();
		input.nextLine();

		
		
		boolean found = false;
		boolean full = true;
		int index = -1;
		
		//go through the courses arraylist
		for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
			//check if there is a course with course name ans section number
			if (Courses.get(i).getCourseName().equals(courseName) && (Courses.get(i).getCourseSectionNumber() == sectionNumber)) {
				
				found = true;
				index = i;
				
				//check if the student is registered in the course already
				for(int k = 0; k < student.size(); k++) {
					if (student.get(k).getFullname().equals(fullName) && student.get(k).getCourses().contains(courseName)) {
						System.out.println("You have already registered to " + courseName + "!");
						return;
					}
				}
				
				//check if the class is full
				if(Courses.get(i).getCurrentStudent() != Courses.get(i).getMaxStudent()) {
					
					Courses.get(i).addCurrentStudent();
					Courses.get(i).addCurrentStudentName(fullName);
					full = false;
				}
				else {
					System.out.println("The course is full!");
				}
			}
		}		
		if(found && !full) {
			for (int j = 0; j < student.size() && student.get(j) != null; j++) {
				if (student.get(j).getFullname().equals(fullName)) {
					student.get(j).addCourses(Courses.get(index).getCourseName());
				}
						
			}
		}
		
		if(!found) {
			System.out.println("The class is not found...");
		}

	}


	
	//take in arraylists as parameters and make changes to both lists
	//delete student name under course
	//delete course name under student
	public static void withdraw(ArrayList<CoursesEntry> Courses, ArrayList<Student> student, String fullName) {
		
		System.out.println("What is the course name you want to withdraw: ");
		String courseName = input.nextLine();
		System.out.println("What is the section number: ");
		int sectionNumber = input.nextInt();
		input.nextLine();
		
		boolean found = false;
		boolean nameFound = false;
		int index = -1;
			
		for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
			if (Courses.get(i).getCourseName().equals(courseName) && (Courses.get(i).getCourseSectionNumber() == sectionNumber)) {
				if (Courses.get(i).getCurrentStudentName().contains(fullName)) {
					
					Courses.get(i).deleteCurrentStudent();
					Courses.get(i).deleteCurrentStudentName(fullName);
					index = i;
					found = true;
				}
				
			}
		}
		for (int j = 0; j < student.size() && student.get(j) != null; j++) {
			
			String[] firstAndLastName = fullName.split(" ");
			
			if (student.get(j).getFirstname().equals(firstAndLastName[0]) && student.get(j).getLastname().equals(firstAndLastName[1])) {
				student.get(j).deleteCourses(Courses.get(index).getCourseName());
				
				nameFound = true;
			}
			
		}
		if (!found) {
			System.out.println("\nCannot find the course...\n");
		}
		if (!nameFound) {
			System.out.println("\nOur system does not have " + fullName + "...\n");
		}

		
	}
	
	//take in arraylist as a parameter and view courses name
	public static void viewAllMyRegisteredCourses(ArrayList<Student> student, String fullName) {
		
		int count = 0;
		
		for (int i = 0; i < student.size(); i++) {
			
			if (student.get(i).getFullname().equals(fullName)) {
				
				if(student.get(i).getCourses().isEmpty()) {
					System.out.println("You are not enrolled in any class yet!");
				}
				else {
					System.out.println("You are currently enrolled in");
					System.out.println("------------------------------------");	
					for(int j = 0; j < student.get(i).getCourses().size(); j++) {					
						System.out.println(student.get(i).getCourses().get(j));
					}
				}	
			}
		}
	}
}
