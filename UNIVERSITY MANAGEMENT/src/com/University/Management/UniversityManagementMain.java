package com.University.Management;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.University.Exceptions.CourseNotFoundException;
import com.University.Exceptions.ProfessorNotFoundException;
import com.University.Exceptions.StudentNotFoundException;

public class UniversityManagementMain {
	
	private List<Student> students;    //List to hold Students
	private List<Professor> professors;
	private List<Course> courses;
	
	public UniversityManagementMain() {
		students = new ArrayList<>();
		professors = new ArrayList<>();
		courses = new ArrayList<>();	
	}
	
	//Method to add a student
	public void addStudent(String name) {
		students.add(new Student(name));
	}
	
	//Method to add a Professor
	public void addProfessor(String name) {
		professors.add(new Professor(name));
	}
	
	//Method to add a Course
	public void addCourse(String title) {
		courses.add(new Course(title));
	}
	
	//Method to Enroll A Student
	public void enrollStudentInCourse(String studentName, String courseTitle) 
		throws StudentNotFoundException,CourseNotFoundException{
			Student student = findStudentByName(studentName);
			Course course = findCourseByTitle(courseTitle);
			if(student == null) {
				throw new StudentNotFoundException("Student " + studentName + " Not Found");
			}if(course == null) {
				throw new CourseNotFoundException("Course " + courseTitle + " Not Found");
			}
			student.enrolledCourse(course);
		}
	
	public void assignCourseToProfessor(String professorName, String courseTitle)throws ProfessorNotFoundException,CourseNotFoundException{
		Professor professor = findProfessorByName(professorName);
		Course course = findCourseByTitle(courseTitle);
		if(professor==null) {
			throw new ProfessorNotFoundException("Professor" + professorName + " Not Found");
		}if(course == null) {
			throw new CourseNotFoundException("Course " + courseTitle + " Not Found");
		}
		professor.assignCourse(course);
	}
	
	// Method to list all Students
	public void listStudents() {
		if(students.isEmpty()) {
			System.out.println("Students data are Not Available");
		}else {
			System.out.println("List of Students ");
			for(Student student:students) {
				System.out.println(student);
			}
		}
	}
		
	// Method to List All Professors
	public void listProfessors() {
		if(professors.isEmpty()) {
			System.out.println("Professor data are Not Available");
		}else {
			System.out.println("List of Professors ");
			for(Professor professor:professors) {
				System.out.println(professor);
			}
		}
	}
	
	
	// Method to List All Courses
	public void listCourses() {
		if(courses.isEmpty()) {
			System.out.println("Courses data are Not Available");
		}else {
			System.out.println("List of Courses ");
			for(Course course:courses) {
				System.out.println(course);
			}
		}
	}
	
	public void displayStudentCourses(String studentName)throws StudentNotFoundException{
		Student student = findStudentByName(studentName);
		if(student == null) {
			throw new StudentNotFoundException("Student " + studentName + " Not Found");
		}
		System.out.println("Courses for Student : " + studentName);
		for(Course course:courses) {
			System.out.println(course);
		}
	}
	
	public void displayProfessorCourses(String professorName)throws ProfessorNotFoundException, StudentNotFoundException{
		Professor professor = findProfessorByName(professorName);
		if(professor == null) {
			throw new StudentNotFoundException("Professor " + professorName + " Not Found");
		}
		System.out.println("Courses Assigned for Professors : " + professorName);
		for(Course course:professor.getAssignedCourses()) {
			System.out.println(course);
		}
	}
	
	public Student findStudentByName(String name) {
		for(Student student:students) {
			if(student.getName().equalsIgnoreCase(name)) {
				return student;
			}
		}
		return null;
	}
	
	public Professor findProfessorByName(String name) {
		for(Professor professor:professors) {
			if(professor.getName().equalsIgnoreCase(name)) {
				return professor;
			}
		}
		return null;
	}
	
	public Course findCourseByTitle(String title) {
		for(Course course:courses) {
			if(course.getTitle().equalsIgnoreCase(title)) {
				return course;
			}
		}
		return null;
	}


	public static void main(String[] args) {
		
		UniversityManagementMain management = new UniversityManagementMain();
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		
		while(running) {
			System.out.println("||***********************************************||");
			System.out.println("||----------UNIVERSITY MANAGEMENT SYSTEM---------||");
			System.out.println("||===============================================||");
			System.out.println("||        1. Add Student                         ||");
			System.out.println("||        2. Add Professor                       ||");
			System.out.println("||        3. Add Courses                         ||");
			System.out.println("||        4. Enrolled Students in Course         ||");
			System.out.println("||        5. Assigned Courses to professor       ||");
			System.out.println("||        6. List Of Students                    ||");
			System.out.println("||        7. List Of Professors                  ||");
			System.out.println("||        8. List Of Courses                     ||");
			System.out.println("||        9. Display Students Courses            ||");
			System.out.println("||       10. Display Professor Courses           ||");
			System.out.println("||       11. EXIT                                ||");
			System.out.println("||===============================================||");
			
			int choice = sc.nextInt();
			sc.nextLine();
			try {
				switch(choice) {
				case 1:
					System.out.println("Enter Student Name :  ");
					String studentName = sc.nextLine();
					management.addStudent(studentName);
					break;
				case 2:
					System.out.println("Enter Professor Name :  ");
					String professorName = sc.nextLine();
					management.addStudent(professorName);
					break;
				case 3:
					System.out.println("Enter Student Name :  ");
					String courseName = sc.nextLine();
					management.addStudent(courseName);
					break;
				case 4:
					System.out.println("Enter Student Name : ");
					String enrollStudent = sc.nextLine();
					System.out.println("Enter Course Title : ");
					String enrollCourse = sc.nextLine();
					try {
						management.enrollStudentInCourse(enrollStudent, enrollCourse);
					}catch(StudentNotFoundException | CourseNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 5:
					System.out.println("Enter Professor Name : ");
					String assignedProfessor = sc.nextLine();
					System.out.println("Enter COurse TItle : ");
					String assignedCourse = sc.nextLine();
					try {
						management.assignCourseToProfessor(assignedProfessor, assignedCourse);
					}catch(ProfessorNotFoundException | CourseNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 6:
					management.listStudents();
					break;
				case 7:
					management.listProfessors();
					break;
				case 8:
					management.listCourses();
					break;
				case 9:
					System.out.println("Enter Student Name : ");
					String displayStudent = sc.nextLine();
					try {
						management.displayStudentCourses(displayStudent);
					}catch(StudentNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 10:
					System.out.println("Enter Professor Name : ");
					String displayProfessor = sc.nextLine();
					try {
						management.displayProfessorCourses(displayProfessor);
					}catch(ProfessorNotFoundException e) {
						e.printStackTrace();
					}
					break;
				case 11:
					running = false;
					System.out.println("Existing.....!");
					break;
				default:
					System.out.println("Invalid Choice.. Please Enter a number 1 TO 11..");
					break;
			}
			
		 }catch(Exception e){
			 e.printStackTrace();
		 }
			
		}
		//sc.close();
	}

}