package ie.atu.sw;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class StudentManager {
	private static final int INITIAL_CAPACITY = 10;
	private Student[] student = null;
	
	public StudentManager() {
		student = new Student[INITIAL_CAPACITY];
		init();
	}

	public void add(Student s) {
		// Loop over the Student array
		for (int i = 0; i < student.length; i++) {
			// Find the first available slot
			if (student[i] == null) {
				// If we find one, put the student into s
				student[i] = s;
				// Return
				return;
			}
		}
		
		// Increase the array size if the array is full
		int index = getExpandedIndex();
		student[index] = s;
	}
	
	// Increase the array size
	private int getExpandedIndex() {
		// Create an array twice the size of the original
		Student[] temp = new Student[student.length * 2];
		// Copy all the old stuff into the new array
		for (int i = 0; i < student.length; i++) {
			temp[i] = student[i];
		}
		
		// Set the next available position to be the original size of the array
		int index = student.length;
		// Change my array to the expanded version
		student = temp;
		return index;
	}
	
	public boolean delete(String sid) {
		// Loop over the collection/array
		for (int i = 0; i < student.length; i++) {
			// if you find what you are looking for
			if (student[i] != null && student[i].sid().equals(sid)) {
				// remove it
				student[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public Student getStudentByID(String sid) {
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].sid().equals(sid)) {
				return student[i];
			}
		}
		return null;
	}
	
	/*
	 * RETURN AN ARRAY - Two sweeps
	 * Sweep 1:
	 * Find all the people with the name, count them, create a correctly sized array
	 * Sweep 2:
	 * Loop over it again, get all of those names and put them into a new array
	 */
	public Student[] getStudentsByFirstname(String firstname) {
		
		// Count the number of matches and create an array of the right size
		int matches = 0; // Declare a counter
		for (int i = 0; i < student.length; i++) { // Loop over the array
			// Check each index
			if (student[i] != null && student[i].firstname().equals(firstname)) {
				// Everytime we get a match - increment the counter
				matches++;
			}
		}
		
		// Copy all of the matches into a new array
		Student[] temp = new Student[matches]; // Declare the array the size of "matches"
		int index = 0;
		// Loop over the original array
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].firstname().equals(firstname)) {
				temp[index] = student[i];
				index++;
			}
		}
		
		return temp;
	}
	
	public int size() {
		int total = 0;
		// Loop over the array
		for (int i = 0; i < student.length; i++) {
			// Check each element
			if (student[i] != null) total++;
		}
		return total;
	}
	
	private void init() {
		// Use ThreadLocalRandom to get some random values
		ThreadLocalRandom rand = ThreadLocalRandom.current();
		
		
		String[] fnames = {"Joe", "Jane", "Anne", "Pat"};
		String[] surnames = {"Smith", "Murphy", "Burke", "O'Brien"};
		// Course is an enum - use .values to return an array of it's values
		Course [] courses = Course.values();
		
		int max = 100_000;
		long start = System.currentTimeMillis();
		
		for (int i = 0; i < max; i++) {
			Student rs = new Student("G00" +i, 
					fnames[rand.nextInt(0, fnames.length)], 
					surnames[rand.nextInt(0, surnames.length)], 
					LocalDate.now(),
					new Address("Galway"), 
					courses[rand.nextInt(0, courses.length)]
			);
			add(rs);
		}
		
		System.out.println("Time (ms) "  + (System.currentTimeMillis() - start));
	}
		
}

