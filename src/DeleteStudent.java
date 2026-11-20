import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteStudent {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/college";
		String username = "jdbcuser";
		String password = "JDBC_Practice_2026!";
		
		String sql = "DELETE FROM students WHERE ID = ?";
		
		try(Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement(sql))
						{
			ps.setInt(1, 103);
			int rows = ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("Student deleted successfully!");
			}else {
				System.out.println("Student not found!");
			}
			
	}catch(SQLException e) {
		e.printStackTrace();
	}
	}
}
