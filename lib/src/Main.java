import java.util.UUID;

import com.aadhar.lib.Attendance;
import com.aadhar.lib.Student;
import com.aadhar.mongo.DBManager;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student(UUID.randomUUID().toString(), "SomeOne", "1",
				"824896510764");
		DBManager dbmanager = new DBManager();
		dbmanager.setIp("192.168.146.134");
		dbmanager.setPort(27017);
		Attendance a=new Attendance("cb7b18f8-e414-4647-a1bc-0bbe90112013", 2015, 2, 1, 2);
		//dbmanager.addAttendance(a);		
		System.out.println(dbmanager.getStudentAttendance(1, 2));
		System.out.println("done");
	}

}
