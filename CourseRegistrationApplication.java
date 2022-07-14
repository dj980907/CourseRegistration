import java.io.*;
import java.util.*;

public class CourseRegistrationApplication {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<CoursesEntry> Courses = new ArrayList<>();
	static ArrayList<Student> studentList = new ArrayList<>();
	
	public static void main(String[] args) {
		//load courses
		loadCourse();
		
		//ask the user to identify themselves
		System.out.println("Log in options");
		System.out.println("	1. admin");
		System.out.println("	2. student");
		System.out.println("(Please enter number)");
		int userInput = input.nextInt();
		input.nextLine();
		
		//if admin
		if (userInput == 1) {
			admin();
		}
		//if student
		else if (userInput == 2) {
			student();
		}
		//if none
		else {
			System.out.println("That was not an option...");
			System.out.println("Since you did not follow the direction, I am going to punish you by exiting the program...");
			System.out.println("Goodbye!");
		}
		

	}
	
	public static void loadCourse() {
		
		CoursesEntry object = null;
		
		try{
			  //FileInputSystem recieves bytes from a file
		      FileInputStream fis = new FileInputStream("ListOfCourses.ser");
		      
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream ois = new ObjectInputStream(fis);
		      
		      Courses = (ArrayList<CoursesEntry>)ois.readObject();
		      
		      System.out.println("courses are deserialized");
		      
		      ois.close();
		      fis.close();
		      
		      //FileInputSystem recieves bytes from a file
		      FileInputStream fis2 = new FileInputStream("ListOfStudents.ser");
		      
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream ois2 = new ObjectInputStream(fis2);
		      
		      studentList = (ArrayList<Student>)ois2.readObject();
		      
		      System.out.println("students are deserialized");
		      
		      ois2.close();
		      fis2.close();
		      
		}
																	
		catch(FileNotFoundException ex) {
			//name of the file to open
			String fileName = "MyUniversityCoursesFile.csv";
			
			System.out.println("deserialization is not working");
									
			//this will reference one line at a time
			String line = null;
									
			String[] classData;
									
			try{
										
				// FileReader reads text files in the default encoding
				FileReader fileReader = new FileReader(fileName);
										
				//always wrap FileReader in BufferedReader
				BufferedReader bufferedReader = new BufferedReader(fileReader);
								
				//read the first line bc it is unnecessary
				//doing this so that it reads from the line 2
				bufferedReader.readLine();
										
				while((line = bufferedReader.readLine()) != null) {
					//read line by line and store it into classData
					classData = line.split(",");
											
					//create a course object with following parameters
					CoursesEntry course = new CoursesEntry(classData[0],classData[1],Integer.parseInt(classData[2]), Integer.parseInt(classData[3]), classData[5], Integer.parseInt(classData[6]), classData[7]);
									
					//add a course into the Courses array list
					Courses.add(course);
				}
										
			//always close the file
			bufferedReader.close();
			}
			
			catch (IOException excep) {
				System.out.println("Error reading file '" + fileName + "'");
			}
			
		}
		
		catch(IOException ioe) {
		       ioe.printStackTrace();
		       return;
		}
								
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		    return;
		}
		
	}
	
	//admin's options
	public static void admin() {
		
		//create an Admin class with username Admin and password Admin001
		Admin admin = new Admin("Admin", "Admin001");
		
		String[] loginInfo = Admin.login();
		
		
		//if the username and password are correct, then display options
		if (loginInfo[0].equals(admin.getUsername()) && loginInfo[1].equals(admin.getPassword())) {
			System.out.println("Welcome " + loginInfo[0] + "!");
			System.out.println("1. Courses management \n2. Reports");
			System.out.print("What would you like to do (Please enter a number): ");
			int option = input.nextInt();
			input.nextLine();
			
			//if courses management
			if (option == 1) {
				boolean keepGoing = true;
				do {
					System.out.println("\nCourse Management");
					System.out.println("	1. Create a new course");
					System.out.println("	2. Delete a course");
					System.out.println("	3. Edit a course");
					System.out.println("	4. Display information for a given course");
					System.out.println("	5. Register a student");
					System.out.println("	6. Exit");
					int userInput = input.nextInt();
					input.nextLine();
					
					if (userInput == 1) {
						Admin.CreateNewCourse(Courses);
					}
					else if (userInput == 2) {
						Admin.Delete(Courses);
					}
					else if (userInput == 3) {
						Admin.Edit(Courses);
					}
					else if (userInput == 4) {
						Admin.searchCourse(Courses);
					}
					else if (userInput == 5) {
						Admin.addStudent(studentList);
					}
					else if (userInput == 6) {
						
						serialize();
						
						System.out.println("Good Bye");
						
						keepGoing = false;
					}
				}
				while(keepGoing);
			}
			
			//if reports
			else if (option == 2) {
				boolean keepGoing = true;
				do {
					System.out.println("\nReports");
					System.out.println("	1. View all courses");
					System.out.println("	2. View all courses that are FULL");
					System.out.println("	3. Write to a file the list of courses that are FULL");
					System.out.println("	4. View the name of the students being registered in a specific course");
					System.out.println("	5. View the list of courses that a given student is being registered on");
					System.out.println("	6. Sort courses based on the current number of student registered");
					System.out.println("	7. Exit");
					int userInput = input.nextInt();
					if (userInput == 1) {
						Admin.ViewAllCourses(Courses);
					}
					else if (userInput == 2) {
						Admin.ViewAllFullCourses(Courses);
					}
					else if (userInput == 3) {
						Admin.writeFullCourses(Courses);
					}
					else if (userInput == 4) {
						Admin.viewRegisteredStudents(Courses);
					}
					else if (userInput == 5) {
						Admin.viewStudentsRegisteredCourses(studentList);
					}
					else if (userInput == 6) {
						Admin.sortByCurrentNumberOfStudents(Courses);
					}
					else if (userInput == 7) {
						System.out.println("Good Bye!");
						keepGoing = false;
					}
					
				}
				while(keepGoing);
			}
		}
		//if the username or password is wrong
		else {
			System.out.println("Wrong username or password as admin... Goodbye!");
			System.out.println("Maybe you are a student???");
		}
		
		

	}
	//student's options
	public static void student() {
		
//		System.out.println("Login");
//		
//		System.out.print("\nUsername: ");
//		String username = input.nextLine();
//		
//		System.out.print("\nPassword: ");
//		String password = input.nextLine();
		
		String[] loginInfo = Student.login();
		
		//go through the student list and see if the username and password match
		//if matches, display menu
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getUsername().equals(loginInfo[0]) && studentList.get(i).getPassword().equals(loginInfo[1])) {
				Student a = new Student(studentList.get(i).getFirstname(),studentList.get(i).getLastname(),studentList.get(i).getUsername(),studentList.get(i).getPassword());
				boolean keepGoing = true;
				do {
					System.out.println("\nCourse Management");
					System.out.println("	1. View all courses");
					System.out.println("	2. View all courses that are NOT FULL");
					System.out.println("	3. Register on a course");
					System.out.println("	4. Withdraw from a course");
					System.out.println("	5. View all courses that I am currently being registered in");
					System.out.println("	6. Exit");
					int userInput = input.nextInt();
					
					input.nextLine();
					
					if (userInput == 1) {
						Student.ViewAllCourses(Courses);
					}
					else if (userInput == 2) {
						Student.ViewAllNotFullCourses(Courses);
					}
					else if (userInput == 3) {
						Student.register(Courses,studentList, a.getFullname());
					}
					else if (userInput == 4) {
						Student.withdraw(Courses, studentList, a.getFullname());
					}
					else if (userInput == 5) {
						a.viewAllMyRegisteredCourses(studentList, a.getFullname());
					}
					else if (userInput == 6) {
						
						serialize();
												
						System.out.println("Good Bye");
						keepGoing = false;
					}
				}
				while(keepGoing);
			}
		}
	}
	
	//method that serialize file
	public static void serialize() {
		
		if(Courses.size()>0) {
			try {
				//FileOutput Stream writes data to a file
				FileOutputStream fos = new FileOutputStream("ListOfCourses.ser");
				
				//ObjectOutputStream writes objects to a stream (A sequence of data)
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(Courses);
				
				
				//Close both streams
				oos.close();
				fos.close();
				
				System.out.println("Courses serialization completed!");
				
			} 
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		if(studentList.size() > 0) {
			
			try {
				//FileOutput Stream writes data to a file
				FileOutputStream fos2 = new FileOutputStream("ListOfStudents.ser");
				
				//ObjectOutputStream writes objects to a stream (A sequence of data)
				ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
				
				oos2.writeObject(studentList);
				
				//Close both streams
				oos2.close();
				fos2.close();
				
				System.out.println("Student serialization completed!");
			}
			catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}
}
