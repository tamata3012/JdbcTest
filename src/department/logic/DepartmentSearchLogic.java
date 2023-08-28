package department.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentSearchLogic {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:postgresql://127.0.0.1:5432/testdb1";
        String user = "postgres";
        String password = "0413";
        
        String searchsql="SELECT * FROM departments ORDER BY department_no ASC ";
        
        try(Connection con=DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt=con.prepareStatement(searchsql)){
        	
        	try(ResultSet rs=pstmt.executeQuery()){
        		
        		while(rs.next()) {
        			System.out.println(
        					rs.getString(1)+","
        					+rs.getString(2)+","
        					+rs.getString(3)
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
