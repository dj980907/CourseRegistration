import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Admin extends User implements java.io.Serializable {
	
	//variables
	private String firstname;
	private String lastname;
	private String username;
	private String password;
//	private static final long serialVersionUID = 1L;
	
	//default constructor
	public Admin() {
		
	}
	
	//constructor with user name, password
	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//constructor with user name, password, first name, last name
	public Admin(String firstname, String lastname, String username, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
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
	
	//take in arraylist as parameter and add the course
	public static void CreateNewCourse(ArrayList<CoursesEntry> Courses) {
		
		String courseName, courseID, courseInstructor,courseLocation;
		int maxStudent,currentStudent,courseSectionNumber;
		
		currentStudent = 0;
		
		System.out.print("\nWhat is the course name: ");
		courseName = input.nextLine();
		System.out.print("\nWhat will be the course ID: ");
		courseID = input.nextLine();
		System.out.print("\nWhat will be the maximum number of student allowed to register: ");
		maxStudent = input.nextInt();
		input.nextLine();
		System.out.print("\nWho is the course instructor: ");
		courseInstructor = input.nextLine();
		System.out.print("\nWhat is the course section number: ");
		courseSectionNumber = input.nextInt();
		input.nextLine();
		System.out.print("\nWhere is the course located: ");
		courseLocation = input.nextLine();
		
		String [] addData = {courseName,courseID, courseInstructor,courseLocation};
		
		CoursesEntry course = new CoursesEntry(addData[0],addData[1],maxStudent,currentStudent,addData[2],courseSectionNumber,addData[3]);
		
		Courses.add(course);
		
	}
	//take in arraylist as a parameter and delete the course from the list
	public static void Delete(ArrayList<CoursesEntry> Courses) {
		
		System.out.print("What is the course name you want to delete: ");
		String courseName = input.nextLine();
		System.out.print("What is the section number of " + courseName + ": ");
		int courseSectionNumber = input.nextInt();
		
		boolean removed = false;
		
		for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
			if (Courses.get(i).getCourseName().equals(courseName) && Courses.get(i).getCourseSectionNumber() == courseSectionNumber) {
				Courses.remove(i);
				removed = true;
			}
		}
		if (removed) {
			System.out.println("It is removed!");
		}
		if (!removed) {
			System.out.println("We couldn't find the course you are looking for...");
		}
	}
	//take in arraylist as a parameter and edit the course
	public static void Edit(ArrayList<CoursesEntry> Courses) {
		
		System.out.print("What is the course name you want to edit: ");
		String courseName = input.nextLine();
		System.out.print("What is the section number of " + courseName + ": ");
		int courseSectionNumber = input.nextInt();
		input.nextLine();
		
		for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
			if (Courses.get(i).getCourseName().equals(courseName) && Courses.get(i).getCourseSectionNumber() == courseSectionNumber) {

				System.out.print("\nEnter the new maximum number of student allowed to register: ");
				int max = input.nextInt();
				input.nextLine();
				System.out.print("\nEnter the new course instructor: ");
				String instructor = input.nextLine();
				System.out.print("\nEnter the new course section number: ");
				int section = input.nextInt();
				input.nextLine();
				System.out.print("\nEnter the new course location: ");
				String location = input.nextLine();
				
				String [] editData = {instructor, location};
				
				Courses.get(i).setMaxStudent(max);
				Courses.get(i).setCourseInstructor(instructor);
				Courses.get(i).setCourseSectionNumber(section);
				Courses.get(i).setCourseLocation(location);
			}
		}
	}
	//take in arraylist as a parameter and look for course and print the info
	public static void searchCourse(ArrayList<CoursesEntry> Courses) {
		System.out.print("What is the course ID you want to look up: ");
		String courseID = input.nextLine();
		boolean found = false;
		
		for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
			if (Courses.get(i).getCourseID().equals(courseID)) {
				Courses.get(i).printCourseInfo();
				found = true;
			}
		}
		if (!found) {
			System.out.println("\nCannot find the course...\n");
		}
	}
	//take in arraylist as a parameter, create a student object and add it to the list
	public static void addStudent(ArrayList<Student> studentList) {
		System.out.println("What is the student' first name: ");
		String firstname = input.nextLine();
		System.out.println("What is the student' last name: ");
		String lastname = input.nextLine();
		System.out.println("Set username for " + firstname + ": ");
		String username = input.nextLine();
		System.out.println("Set password for " + firstname + ": ");
		String password = input.nextLine();
		
		String[] studentInfo = {firstname, lastname, username, password};
		
		Student student = new Student(studentInfo[0],studentInfo[1],studentInfo[2],studentInfo[3]);
		
		studentList.add(student);
	}
	
	public static void ViewAllCourses(ArrayList<CoursesEntry> Courses) {
		System.out.println("\nAll the courses offered: admin version");
		for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
			if (Courses.get(i).getCourseName() != "") {
				Courses.get(i).printCourseInfo();
			}
		}
	}
	
	//take in arraylist as a parameter and print the info for full courses
	public static void ViewAllFullCourses(ArrayList<CoursesEntry> Courses) {
		
		ArrayList<CoursesEntry> FullCourses = new ArrayList<>();
		
		for(int k = 0; k < Courses.size(); k++) {
			if (Courses.get(k).getCurrentStudent() >= Courses.get(k).getMaxStudent()) {
				FullCourses.add(Courses.get(k));
			}
		}
		
		System.out.println("\nThese are courses that are full!");
		System.out.println("--------------------------------------------------");

		
		for (int i = 0; i < FullCourses.size() && FullCourses.get(i) != null; i++) {
			if (FullCourses.get(i).getCourseName()!= "") {
				FullCourses.get(i).printCourseInfo();
			}
		}
	}
	//take in arraylist as a parameter and write the full course in a text file
	public static void writeFullCourses(ArrayList<CoursesEntry> Courses) {
		
		ArrayList<CoursesEntry> FullCourses = new ArrayList<>();
		
		for(int k = 0; k < Courses.size(); k++) {
			if (Courses.get(k).getCurrentStudent() >= Courses.get(k).getMaxStudent()) {
				FullCourses.add(Courses.get(k));
			}
		}
		
		for (int i = 0; i < FullCourses.size() && FullCourses.get(i) != null; i++) {
			if (FullCourses.get(i).getCourseName()!= "") {
				
				String fileName = "fullCourses.txt";
				
				Scanner scan = new Scanner(System.in);
				
				try{
					
					FileWriter fileWriter = new FileWriter(fileName);
					
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					
					String text = scan.nextLine();
					
					bufferedWriter.write(text);

					bufferedWriter.write(FullCourses.get(i).getCourseName());
					
					bufferedWriter.newLine();

					
					//Always close writer
					bufferedWriter.close();
				}

				//Always close files

				catch (IOException exk) {
					System.out.println( "Error writing file '" + fileName + "'");
					exk.printStackTrace();
				}
				
			}
			
		}
		
	}
	//take in arraylist as a parameter and look for a class and print out the name of the student enrolled in that course
	public static void viewRegisteredStudents(ArrayList<CoursesEntry> Courses) {
		
		System.out.print("What is the course name you want to look up: ");
		String courseName = input.nextLine();
		
		System.out.print("What is the section number: ");
		int sectionNumber = input.nextInt();
		input.nextLine();
		
		boolean found = false;
		boolean noStudent = true;
		
		//go through the list of courses
		for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
			
			//if the course is found
			if (Courses.get(i).getCourseName().equals(courseName) && (Courses.get(i).getCourseSectionNumber() == sectionNumber)) {
				
				//check if it is empty
				//if it is, print message
				if(Courses.get(i).getCurrentStudentName().isEmpty()) {
					System.out.println("\nNo student in this course");
					return;
				}
				//if not empty, print list of students
				else {
					System.out.println("\nThese are the students registered in " + courseName + "section " + sectionNumber);
					System.out.println("-------------------------------------------------------");
					
					for(int j = 0; j < Courses.get(i).getCurrentStudentName().size(); j++) {					
						System.out.println(Courses.get(i).getCurrentStudentName().get(j));
					}
					found = true;
				}
			
			}
		}
		//if the course is not found, then print this;
		if (!found) {
			System.out.println("\nCannot find the course...");
		}
	}
	//take in arraylist as a parameter and print out the course that he or she is registered in
	public static void viewStudentsRegisteredCourses(ArrayList<Student> student) {
		
		System.out.print("What is the student's first name you want to look up: ");
		String studentFirstName = input.nextLine();
		System.out.print("What is the student's last name you want to look up: ");
		String studentLastName = input.nextLine();
		boolean found = false;
		boolean noCourse = false;
		
		//go through the student list
		for (int i = 0; i < student.size() && student.get(i) != null; i++) {
			
			//go to corresponding student with first and last name
			if (student.get(i).getFirstname().equals(studentFirstName) && student.get(i).getLastname().equals(studentLastName)) {
				
				found = true;
				
				//check if the course list is empty
				//if it is then print message
				if(student.get(i).getCourses().isEmpty()) {
					noCourse = true;
				}
				
				else {
					System.out.println("\n" + student.get(i).getFullname() + " has the following courses");
					System.out.println("----------------------------------------------");
					for(int j = 0; j < student.get(i).getCourses().size(); j++) {					
						System.out.println(student.get(i).getCourses().get(j));
					}
					
				}
				
			}
	
		}
		if(noCourse) {
			System.out.println("\nThis student does not have any course registered!");
		}
		
		if (!found) {
			System.out.println("\nCannot find the student in the system...\n");
		}
	}
	//take in arraylist as a parameter and sort it by current number of student
	public static void sortByCurrentNumberOfStudents(ArrayList<CoursesEntry> Courses) {
		
		for (int i = 0; i < Courses.size(); i++) {
			
			for (int j = Courses.size() - 1; j > i; j--) {
				if (Courses.get(i).getCurrentStudent() > Courses.get(j).getCurrentStudent()) {
					
					CoursesEntry temp = Courses.get(i);
					Courses.set(i, Courses.get(j));
					Courses.set(j, temp);
					
				}
			}
			
		}
	}
//	//method that create txt file for the full course
//	public static void CreateFile() {
//		//initialize File object and passing path as argument  
//		File file = new File("fullCourses.txt");
//		boolean result;  
//		try   {  
//			//creates a new file and return true if successful 
//			result = file.createNewFile();
//			
//			// test if successfully created a new file
//			if(result){ 
//				//returns the path string  
//				System.out.println("file created "+file.getCanonicalPath());
//			}  
//			else  {  
//				System.out.println("File already exist at location: "+file.getCanonicalPath());  
//			}  
//		}
//		
//		catch (IOException e)   {
//			//prints exception if any  
//			e.printStackTrace();    
//		}         
//	} 
	
}
