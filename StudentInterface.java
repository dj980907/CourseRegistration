import java.util.ArrayList;

public interface StudentInterface {
	public void ViewAllCourses(ArrayList<CoursesEntry> Courses);
	public void ViewAllNotFullCourses(ArrayList<CoursesEntry> Courses);
	public void register(ArrayList<CoursesEntry> Courses, ArrayList<Student> student, String fullName);
	public void withdraw(ArrayList<CoursesEntry> Courses, ArrayList<Student> student, String fullName);
	public void viewAllMyRegisteredCourses(ArrayList<Student> student, String fullName);
}
