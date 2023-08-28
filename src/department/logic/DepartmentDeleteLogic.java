package department.logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentDeleteLogic {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:postgresql://127.0.0.1:5432/testdb1";
        String user = "postgres";
        String password = "0413";
        
        String sql="DELETE FROM departments WHERE department_no=?";
        
        try(Connection con=DriverManager.getConnection(url, user, password);
        	PreparedStatement pstmt=con.prepareStatement(sql)){
        	
    		pstmt.setString(1, "8");
        	
        	int count=pstmt.executeUpdate();   
        	
        	if(count==1) {
        		 System.out.println("処理が完了しました");
        	}
        }
	}
}
