package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class StudentDao {

	public static boolean insertStudentToDB(Student st) {
		boolean f = false;
		try {
			// jdbc code..
			Connection con = CP.create();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			
			//prepare statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			
			f = true;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			// jdbc code..
			Connection con = CP.create();
			String q = "delete from students where sid = ?";
			
			//prepare statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setInt(1, userId);
			
			
			//execute
			pstmt.executeUpdate();
			
			f = true;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return f;
		
		
	}

	public static boolean showAllStudent() {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			// jdbc code..
			Connection con = CP.create();
			String q = "select * from students";
			
			// statement
			
			Statement stmt = con.createStatement();
			
//			pstmt.setInt(1, userId);
			
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				
				System.out.println("ID: "+id);
				System.out.println("Name: "+name);
				System.out.println("Phone: "+phone);
				System.out.println("City: "+city);
				
				System.out.println("==========================================");
			}
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return f;
		
	}

	public static boolean updateStudent(Student st) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			// jdbc code..
			Connection con = CP.create();
			String q = "UPDATE students SET sname = ?, sphone = ?, scity = ? WHERE sid = ?";
			
			//prepare statement
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.setInt(4, st.getStudentId());
			
			//execute
			pstmt.executeUpdate();
			
			f = true;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return f;
	}

}
