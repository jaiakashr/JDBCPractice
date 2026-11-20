import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchStudent {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "jdbcuser";
		String password = "JDBC_Practice_2026!";
		
		String sql = "SELECT * FROM students WHERE marks > ? AND course = ?";
		
		try(Scanner scan = new Scanner(System.in);
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement(sql);)
		{
			System.out.println("Enter student marks : ");
			int marks = scan.nextInt();
			scan.nextLine();
			
			System.out.println("Enter student course : ");
			String course = scan.nextLine();
			
			ps.setInt(1, marks);
			ps.setString(2, course);
			
			try (ResultSet rs = ps.executeQuery()){
				if(rs.next()) {
					System.out.println("Student found!");
					System.out.println("ID : " + rs.getInt("id"));
					System.out.println("Name : " + rs.getString("name"));
					System.out.println("Marks : " + rs.getInt("marks"));
					System.out.println("Course : " + rs.getString("course"));
				}else {
					System.out.println("Student not found!");
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
