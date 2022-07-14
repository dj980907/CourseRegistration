import java.util.ArrayList;

public interface AdminInterface {
	
	public void CreateNewCourse(ArrayList<CoursesEntry> Courses);
	public void Delete(ArrayList<CoursesEntry> Courses);
	public void Edit(ArrayList<CoursesEntry> Courses);
	public void searchCourse(ArrayList<CoursesEntry> Courses);
	public void addStudent();
	
	public void ViewAllCourses(ArrayList<CoursesEntry> Courses);
	public void ViewAllFullCourses(ArrayList<CoursesEntry> Courses);
	public void writeFullCourses(ArrayList<CoursesEntry> Courses);
	public void viewRegisteredStudents(ArrayList<CoursesEntry> Courses);
	public void viewStudentsRegisteredCourses(ArrayList<Student> student);
	public void sortByCurrentNumberOfStudents(ArrayList<CoursesEntry> Courses);
}
