package ie.atu.sw;

import java.io.*;
public class DatabaseUtils {

	public static void save(StudentManager sm, String fileName) throws Exception {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
			out.writeObject(sm);
			out.close();
		} catch (IOException e) {
			throw new Exception("[Error] Cannot save the Student Manager to " + fileName + ". " + e.getMessage());
		}
	}
	
	// Instead of taking in a StudentManager, return a StudentManager
	public static StudentManager load(String fileName) throws Exception {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File(fileName)));
			StudentManager sm = (StudentManager) in.readObject();
			in.close();
			return sm;
		} catch (IOException e) {
			throw new Exception("[Error] Cannot load the Student Manager from " + fileName + ". " + e.getMessage());
		}
	}
}