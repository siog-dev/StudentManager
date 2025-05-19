package ie.atu.sw;

public class StudentManager {
	private static final int INITIAL_CAPACITY = 10;
	private Student[] student = null;
	
	public StudentManager() {
		student = new Student[INITIAL_CAPACITY];
	}

	public void add(Student s) {
		for (int i = 0; i < student.length; i++) {
			if (student[i] == null) {
				student[i] = s;
				return;
			}
		}
	}
	
	public boolean delete(String sid) {
		// Loop over the collection/array
		for (int i = 0; i < student.length; i++) {
			// if you find what you are looking for
			if (student[i] != null && student[i].firstname().equals(sid)) {
				// remove it
				student[i] = null;
				return true;
			}
		}
		return false;
	}
	
	public Student getStudentByID(String sid) {
		for (int i = 0; i < student.length; i++) {
			if (student[i] != null && student[i].firstname().equals(sid)) {
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
}

