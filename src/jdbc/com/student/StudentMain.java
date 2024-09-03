package jdbc.com.student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) throws SQLException, IOException {
		// TODO Auto-generated method stub

//		StudentPojo student=new StudentPojo();
		System.out.println("Welcome to Student Management App!!");

		StudentCRUDoperations crud = new StudentCRUDoperations();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Please enter any number between 1-4");
			int i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("Enter Student Name:");
				String name = br.readLine();
				System.out.println("Enter Student Age:");
				int age = Integer.parseInt(br.readLine());
				System.out.println("Enter Student City:");
				String city = br.readLine();
				System.out.println("Enter Student city Pincode:");
				long pincode = Long.parseLong(br.readLine());

				StudentPojo student = new StudentPojo(name, age, city, pincode);
				int ansInsert=crud.insertStudent(student);
				if (ansInsert > 0) {
					System.out.println("Student Inserted Successfully: \n"+student);
				} else {
					System.out.println("Error in Insertion!");
				}
				break;
				
			case 2:
				crud.displayStudent();
				break;
				
			case 3:
				System.out.println("Enter Student ID to be updated:");
				int studentID = Integer.parseInt(br.readLine());
				System.out.println("Enter updated student age:");
				int ageupdate = Integer.parseInt(br.readLine());
				System.out.println("Enter updated student city:");
				String cityupdate = br.readLine();
				
				int ansUpdate=crud.updateStudent(studentID,ageupdate,cityupdate);
				if (ansUpdate > 0) {
					System.out.println("Student Updated Successfully");
				} else {
					System.out.println("Error in Update!");
				}
				break;
			case 4:
				System.out.println("Enter Student ID to be Deleted:");
				int ID = Integer.parseInt(br.readLine());
				int ansDelete=crud.deleteStudent(ID);
				if (ansDelete > 0) {
					System.out.println("Student Deleted Successfully");
				} else {
					System.out.println("Error in Delete!");
				}
				break;
			default:
				System.out.println("Wrong Number please try again!!\nThank you for using the Student App!");
				sc.close();
				System.exit(0);
				break;
			}
		}
	}
}
