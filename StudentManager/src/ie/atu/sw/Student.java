package ie.atu.sw;

import java.time.LocalDate;

public class Student {
	private String sid;
	private String firstName;
	private String surname;
	private LocalDate dob;
	private Address address;
	private Course course;
	
	// Use source to generate constructor using fields
	public Student(String sid) {
		super();
		this.sid = sid;
	}

	// Use source to generate constructor using fields
	public Student(String sid, String firstName, String surname, LocalDate dob) {
		super();
		this.sid = sid;
		this.firstName = firstName;
		this.surname = surname;
		this.dob = dob;
	}
	
}
