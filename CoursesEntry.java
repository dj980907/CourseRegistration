import java.util.*;

public class CoursesEntry implements java.io.Serializable{
	
	//variables
	private String CourseName;
	private String CourseID;
	private int MaxStudent;
	private int CurrentStudent;
	private ArrayList<String> CurrentStudentName;
	private String CourseInstructor;
	private int CourseSectionNumber;
	private String CourseLocation;
	private static final long serialVersionUID = 1L;
	
	
	//default constructor
	public CoursesEntry() {
		
	}
	
	//constructor with parameters
	public CoursesEntry(String CourseName, String CourseID, int MaxStudent, int CurrentStudent, String CourseInstructor, int CourseSectionNumber, String CourseLocation) {
		this.CourseName = CourseName;
		this.CourseID = CourseID;
		this.MaxStudent = MaxStudent;
		this.CurrentStudent = CurrentStudent;
		this.CurrentStudentName = new ArrayList<>();
		this.CourseInstructor = CourseInstructor;
		this.CourseSectionNumber = CourseSectionNumber;
		this.CourseLocation = CourseLocation;
	}
	
	//course name getter
	public String getCourseName() {
		return CourseName;
	}
	
	//course name setter
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	
	//course ID getter
	public String getCourseID() {
		return CourseID;
	}
	
	//course ID setter
	public void setCourseID(String courseID) {
		CourseID = courseID;
	}
	
	//maximum student getter
	public int getMaxStudent() {
		return MaxStudent;
	}
	
	//maximum student setter
	public void setMaxStudent(int maxStudent) {
		MaxStudent = maxStudent;
	}
	
	//current student getter
	public int getCurrentStudent() {
		return CurrentStudent;
	}
	
	//current student adder
	public void addCurrentStudent() {
		CurrentStudent = CurrentStudent + 1;
	}
	
	//current student deleter
	public void deleteCurrentStudent() {
		CurrentStudent  = CurrentStudent - 1;
	}
	
	//current student name getter
	public ArrayList<String> getCurrentStudentName(){
		return CurrentStudentName;
	}
	
	//current student name adder
	public void addCurrentStudentName(String student) {
		CurrentStudentName.add(student);
	}
	
	//current student name deleter
	public void deleteCurrentStudentName(String student) {
		CurrentStudentName.remove(student);
	}
	
	//course instructor getter
	public String getCourseInstructor() {
		return CourseInstructor;
	}
	
	//course instructor setter
	public void setCourseInstructor(String courseInstructor) {
		CourseInstructor = courseInstructor;
	}
	
	//course section number getter
	public int getCourseSectionNumber() {
		return CourseSectionNumber;
	}
	
	//course section number setter
	public void setCourseSectionNumber(int courseSectionNumber) {
		CourseSectionNumber = courseSectionNumber;
	}
	
	//course location getter
	public String getCourseLocation() {
		return CourseLocation;
	}
	
	//course location setter
	public void setCourseLocation(String courseLocation) {
		CourseLocation = courseLocation;
	}
	
	//print info
	public void printCourseInfo() {
		System.out.println("\nCourse Name: " + CourseName + "\nCourse ID: " + CourseID + "\nMaximum Student: " + MaxStudent + "\nCurrent Number Of Student: " + CurrentStudent);
		System.out.println("Current Student Name: " + CurrentStudentName);
		System.out.println("Course Instructor: " + CourseInstructor + "\nCourse Section Number: " + CourseSectionNumber + "\nCourse Location: " + CourseLocation);

	}

}
