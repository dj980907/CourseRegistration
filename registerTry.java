import java.util.ArrayList;

public class registerTry {
}

//public static void register(ArrayList<CoursesEntry> Courses, ArrayList<Student> student, String fullName) {
//		
//		System.out.println("What is the course name you want to register: ");
//		String courseName = input.nextLine();
//		System.out.println("What is the section number: ");
//		int sectionNumber = input.nextInt();
//		input.nextLine();
//
//		
//		
//		boolean found = false;
//		boolean full = true;
//		int index = -1;
//		
//		//go through the courses arraylist
//		for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
//			//check if there is a course with course name ans section number
//			if (Courses.get(i).getCourseName().equals(courseName) && (Courses.get(i).getCourseSectionNumber() == sectionNumber)) {
//				
//				found = true;
//				index = i;
//				
//				//check if the student is registered in the course already
//				for(int k = 0; k < student.size(); k++) {
//					if (student.get(k).getFullname().equals(fullName) && student.get(k).getCourses().contains(courseName)) {
//						System.out.println("You have already registered to " + courseName + "!");
//						return;
//					}
//				}
//				
//				//check if the class is full
//				if(Courses.get(i).getCurrentStudent() != Courses.get(i).getMaxStudent()) {
//					
//					Courses.get(i).addCurrentStudent();
//					Courses.get(i).addCurrentStudentName(fullName);
//					full = false;
//				}
//				else {
//					System.out.println("The course is full!");
//				}
//			}
//		}		
//		if(found && !full) {
//			for (int j = 0; j < student.size() && student.get(j) != null; j++) {
//				if (student.get(j).getFullname().equals(fullName)) {
//					student.get(j).addCourses(Courses.get(index).getCourseName());
//				}
//						
//			}
//		}
//		
//		if(!found) {
//			System.out.println("The class is not found...");
//		}
//
//	}
//}


//public static void register(ArrayList<CoursesEntry> Courses, ArrayList<Student> student, String fullName) {
//	
//	System.out.println("What is the course name you want to register: ");
//	String courseName = input.nextLine();
//	System.out.println("What is the section number: ");
//	int sectionNumber = input.nextInt();
//	input.nextLine();
//
//	
//	
//	boolean found = false;
//	boolean full = true;
//	int index = -1;
//	
//	//go through the courses arraylist
//	for (int i = 0; i < Courses.size() && Courses.get(i) != null; i++) {
//		//check if there is a course with course name ans section number
//		if (Courses.get(i).getCourseName().equals(courseName) && (Courses.get(i).getCourseSectionNumber() == sectionNumber)) {
//			
//			found = true;
//			index = i;
//			//check if the class is full
//			if(Courses.get(i).getCurrentStudent() != Courses.get(i).getMaxStudent()) {
//				
//				for(int k = 0; k < student.size(); k++) {
//					if (student.get(k).getFullname().equals(fullName) && student.get(k).getCourses().contains(courseName)) {
//						System.out.println("You have already registered to " + courseName + "!");
//						return;
//					}
//				}
//				
//				Courses.get(i).addCurrentStudent();
//				Courses.get(i).addCurrentStudentName(fullName);
//				full = false;
//			}
//			else {
//				System.out.println("The course is full!");
//			}
//		}
//	}		
//	if(found && !full) {
//		for (int j = 0; j < student.size() && student.get(j) != null; j++) {
//			if (student.get(j).getFullname().equals(fullName)) {
//				student.get(j).addCourses(Courses.get(index).getCourseName());
//			}
//					
//		}
//	}
//	
//	if(!found) {
//		System.out.println("The class is not found...");
//	}
//
//}
