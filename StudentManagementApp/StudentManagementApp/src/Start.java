import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("This is running.....");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to Add Students");
			System.out.println("Press 2 to Delete Students");
			System.out.println("Press 3 to Display Students");
			System.out.println("Press 4 to update Students");
			System.out.println("Press 5 to exit");
			
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1) {
				//add student 
				
				System.out.println("Enter user name");
				String name = br.readLine();
				
				System.out.println("Enter user phone number");
				String phone = br.readLine();
				
				System.out.println("Enter user city");
				String city = br.readLine();
				
				//create obj to store student
				
				Student st = new Student(name, phone, city);
				
				boolean answer = StudentDao.insertStudentToDB(st);
				
				if(answer) {
					System.out.println("Student details sucessfully added....");
				}else {
					System.out.println("Something went wrong!!!!!");
				}
				System.out.println(st);
				
			}else if(c == 2) {
				//delete student
				System.out.println("Enter student id to delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean f = StudentDao.deleteStudent(userId);
				
				if(f) {
					System.out.println("Deleted");
				}else {
					System.out.println("Somthing went wrong!!!....");
				}
				
			}else if(c == 3) {
				//display stduent
				
				StudentDao.showAllStudent();
				
				
			}else if(c == 4) {
				//exit
				//user input for update 
				System.out.println("Enter user name");
				String name = br.readLine();
				
				System.out.println("Enter user phone number");
				String phone = br.readLine();
				
				System.out.println("Enter user city");
				String city = br.readLine();
				
				System.out.println("Enter user Id");
				int ID = Integer.parseInt(br.readLine());
				
//				object of students input
				Student st = new Student(ID,name, phone, city);
				
				boolean ans = StudentDao.updateStudent(st);
				
				if(ans) {
					System.out.println("Update sucessfully...");
				}else {
					System.out.println("Error in input..!!");
				}
				
			}else if(c == 5){
				break;
				
			}
		}
	}

}
