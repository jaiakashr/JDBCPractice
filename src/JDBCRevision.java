import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCRevision {
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "jdbcuser";
		String password = "JDBC_Practice_2026!";
		
		String sql = "SELECT * FROM students WHERE marks> ? AND course = ?";
		
		try (Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = con.prepareStatement(sql)) 
			{
			ps.setInt(1, 70);
			ps.setString(2, "java");
			
			try(ResultSet rs = ps.executeQuery()){
			
			System.out.println("Database connected Successfully! ");
			System.out.println();
			
			boolean found = false;
			
			while(rs.next()) {
				found = true;
				
				System.out.println("Name : "+ rs.getString("name"));
				System.out.println("ID : "+ rs.getInt("id"));
				System.out.println("Age : "+ rs.getInt("age"));
				System.out.println("Marks : "+ rs.getInt("marks"));
				System.out.println("Course : "+ rs.getString("course"));
				System.out.println("-----------------------");
				System.out.println();
			}
			if(!found){
				System.out.println("Student not found!");
			}
		}
//			if(con != null) {
//				System.out.println("Database connected successfully!. ");
//			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
}
