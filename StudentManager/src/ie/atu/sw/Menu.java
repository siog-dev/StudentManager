package ie.atu.sw;

import static java.lang.System.out;
import java.util.Scanner;

public class Menu {
	private StudentManager sm = new StudentManager();
	private Scanner s;
	private boolean keepRunning = true;
	
	public Menu() {
		s = new Scanner(System.in);
	}
	
	public void start() {
		while (keepRunning) {
			showOptions();
			
			int choice = Integer.parseInt(s.next());
			switch (choice) {
				case 1  -> add();
				case 2  -> delete();
				case 3  -> findByID();
				case 4  -> findStudentsByFirstname();
				case 5  -> getTotal();
				case 6  -> keepRunning = false;
				default -> out.println("[Error] Invalid Selection");
			}
		}
		out.println("[INFO] Exiting...Bye!");
	}
	
	private void add() {
		out.println("[INFO] Add a Student");
		
		out.println("Enter Student ID>");
		String sid = s.next();
		
		out.println("Enter Student Firstname>");
		String fname = s.next();
		
		out.println("Enter Student Surname>");
		String surname = s.next();
		
	}
	
	private void delete( ) {
		out.println("[INFO] Delete a Student");
		out.println("Enter Student ID>");
		String sid = s.next();
		
		if (sm.delete(sid)) {
			out.println("[INFO] Student " + sid + " deleted.");
		}else {
			out.println("[INFO] Cannot find Student" + sid);
		}
	}
	
	private void findByID() {
		out.println("[INFO] Find Student by ID");
		out.println("Enter Student ID>");
		String sid = s.next();
		/*
		 * get Student called student and assign it the value
		 * of sm(student manager) .getStudentByID() <-- pass in sid
		 */
		Student student = sm.getStudentByID(sid);
		
		if (student != null) {
			out.println(student);
		}else {
			out.println("[INFO] Cannot find Student" + sid);
		}
	}
	
	private void findStudentsByFirstname() {
		out.println("[INFO] Find Student by Firstname");
		out.println("Enter Student Firstname>");
		String fname = s.next();
		
		Student[] results = sm.getStudentsByFirstname(fname);
		for (Student student : results) {
			out.println(student);
		}
	}
	
	private void getTotal() {
		// Append sm(StudentManager identifier) and call size() using dot notation
		out.println("Total Number of Students: " + sm.size());
	}
	
	private void showOptions() {
		out.println("******************************");
		out.println("**    Student Manager 1.0   **");
		out.println("******************************");
		out.println("(1) Add a Student");
		out.println("(2) Delete a Student");
		out.println("(3) Find Student by ID");
		out.println("(4) Find Students by Firstname");
		out.println("(5) Get Total Student Number");
		out.println("(6) Quit");
		out.println("Select an Option [1 - 6]>");
		
	}
}
