package ie.atu.sw;

public enum Course {
	SOFT_DEV 	("Software Development", "Computing"),
	DATA_ANA 	("Data Analytics", "Computing"),
	WEB_DEV 	("Web Application Development", "Computing"),
	CHEM 		("Chemistry", "Science"),
	PHYS 		("Physics", "Science"),
	MEDI 		("Medicine", "Medicine"),
	ACC 		("Accounting", "Commerce");

	private final String cname;
	private final String cfaculty;
	
	Course(String name, String faculty) {
		
	}
	
}
