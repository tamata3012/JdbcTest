package employee.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSearchLogic {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:postgresql://127.0.0.1:5432/testdb1";
        String user = "postgres";
        String password = "0413";
        
        String searchsql="SELECT * FROM employees ORDER BY employee_no ASC ";
        
        try(Connection con=DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt =con.prepareStatement(searchsql)){
        	
        	try(ResultSet rs=pstmt.executeQuery()){
        		
        		while(rs.next()) {
        			System.out.println(
        					rs.getString("employee_no")+","
        					+rs.getString(2)+","
        					+rs.getString(3)+","
        					+rs.getString(4)+","
        					);
        		}
        		
        	} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
	            System.out.println("処理が完了しました");
	        }
        }
        
	}
}
