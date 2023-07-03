# CourseRegistration

This is a course registration program for university administrators and students. <br />
This program is designed to demonstrate my understanding of `Serialization`, `interface`, and `object oriented programming paradigm`.<br />
It deserialize the ser file in the beginning (if exists), ad serialize at the end of the program (always). <br />
Both `Admin` and `Student` inherit from a class `User`, each class implements `AdminInterface` and `StudentInterface`.<br />

## Reading the csv/ser file

The university has classes listed in `MyUniversityCoursesFile.csv`. 

Program will execute the following logic:
- if it is the first time running the program, it will read all the datas from the csv file and create course objects with `course name`, `course id`, `maximum student`, `current student`, `list of names`, `instructor`, `section number`, and `location`.
- if it is not the first time, then it will load all the datas from serialized file and create course objects.

## User Validation

First, the program checks if the user is an administrator or student.

Then, it asks the user for the username and password. 
For simplicity, Admin's username is `Admin` and password is `Admin001` and Student's username and password has to be set up by the administrator before the student logs in.

```
Log in options
	1. admin
	2. student
(Please enter number)
```

After logging in as an administrator, following screen will be shown:

```
Welcome Admin!
        1. Courses management 
        2. Reports
What would you like to do (Please enter a number): 
```

When the admin chooses `Course Management`, the screen will display the following:

```
Course Management
	1. Create a new course
	2. Delete a course
	3. Edit a course
	4. Display information for a given course
	5. Register a student
	6. Exit
```

When the admin chooses `Report`, the screen will display the following:

```
Reports
	1. View all courses
	2. View all courses that are FULL
	3. Write to a file the list of courses that are FULL
	4. View the name of the students being registered in a specific course
	5. View the list of courses that a given student is being registered on
	6. Sort courses based on the current number of student registered
	7. Exit
```

## Method Details (Admin)

`Admin` class utilize 12 methods: 
- `login`: verifies the username and password of Admin.
- `CreateNewCourse`: creates new course by inputing necessary fields such as name, id, instructor, and etc.
- `Delete`: deletes a course from the course list.
- `Edit`: edits a specific course inputed by the user.
- `searchCourse`: searches for an inputed course.
- `addStudent`: adds a student before the student uses the program.
- `ViewAllCourses`: displays all the courses in the university.
- `ViewAllFullCourses`: displays all the courses that are full.
- `writeFullCourses`: write all the full courses into a text file.
- `viewRegisteredStudents`: displays students who are registered to a specific course.
- `viewStudentsRegisteredCourses`: display all the courses that a student is registered in.
- `sortByCurrentNumberOfStudents`: sort the courses by the current number of students.

## Method Details (Student)

`Student` class utilize 6 methods: 
- `login`: verifies the username and password of the student.
- `ViewAllCourses`: displays all the courses in the university.
- `ViewAllNotFullCourses`: displays all the courses that are NOT full.
- `register`: register for the specific course inputed by the user.
- `withdraw`: withdraw from a course that the student is already registered in.
- `viewAllMyRegisteredCourses`: displays all the courses that the student is registered in.
