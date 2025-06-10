package ie.atu.sw;

import java.io.*;
public class DatabaseUtils {

	public void save(StudentManager sm, String fileName) {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
		out.writeObject(sm);
		out.close();
	}
	
}