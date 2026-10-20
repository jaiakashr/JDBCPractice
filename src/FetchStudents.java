import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchStudents {
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/college";
        String username = "jdbcuser";
        String password = "JDBC_Practice_2026!";
        
        String sql = "SELECT * FROM students WHERE marks>70";
        
        try (
            Connection con = DriverManager.getConnection(
                    url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)
            		){
        	while(rs.next()) {
        		int id = rs.getInt("id");
        		String name = rs.getString("name");
        		int marks = rs.getInt("marks");
        		
        		System.out.println("ID : "+ id);
        		System.out.println("Name : "+ name);
        		System.out.println("Marks : "+ marks);
        		System.out.println("---------------------");
            }
            
        }
        
        catch (SQLException e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
	}

}
