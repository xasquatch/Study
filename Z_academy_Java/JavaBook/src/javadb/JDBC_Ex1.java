package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC_Ex1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String i = sc.nextLine();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "1234");
			System.out.println("DB연결 완료");
//			Statement stmt = con.createStatement();
//
////			stmt.executeUpdate("INSERT INTO student(name,dept,id) VALUES('아무','C','16')");
////			stmt.executeUpdate("UPDATE student SET name = '아무것도아님' WHERE name = '아무');
////			stmt.executeUpdate("DELETE FROM student WHERE name = '아무'");
//			
//			
//			ResultSet rs = stmt.executeQuery("SELECT * FROM student");

			String sql = "SELECT * FROM student WHERE id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, i);
			ResultSet rs = pstmt.executeQuery();
			
			
			
			
			while (rs.next()) {
				System.out.printf("%s\t", rs.getString(1));
				System.out.printf("%s\t", rs.getString(3));
				System.out.println(rs.getString(2));

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로드 exception");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB연결 exception");
		}

	}

}
