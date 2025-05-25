package ie.atu.sw;

import static java.lang.System.out;
import java.util.Scanner;

public class Menu {
	private Scanner s;
	// Exit gracefully, set keepRunning to true
	private boolean keepRunning = true;
	
	public Menu() {
		s = new Scanner(System.in);
	}
	
	public void start() {
		// Display the menu
		while (keepRunning) {
			// Get options from the user
			showOptions();
			
			/*
			 * Get users option choice, a number between 1 and 6
			 * Read in the users option choice (num 1 -6)
			 * Scanner reads it as a string
			 * Convert to int
			 */
			
			/*
			 * int called choice is assigned the value of
			 * the integer, parse out the integer value from the next string
			 * 
			 * When we get to next the program will wait for user input
			 */
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
	}
	
	private void delete( ) {
		out.println("[INFO] Delete a Student");
	}
	
	private void findByID() {
		out.println("[INFO] Find Student by ID");
	}
	
	private void findStudentsByFirstname() {
		out.println("[INFO] Find Student by Firstname");
	}
	
	private void getTotal() {
		out.println("[INFO] Total Number of Students");
	}
	
	private void showOptions() {
		out.print("******************************");
		out.print("**    Student Manager 1.0   **");
		out.print("******************************");
		out.print("(1) Add a Student");
		out.print("(2) Delete a Student");
		out.print("(3) Find Student by ID");
		out.print("(4) Find Students by Firstname");
		out.print("(5) Get Total Student Number");
		out.print("(6) Quit");
		out.print("Select an Option [1 - 6]>");
		
	}
}
