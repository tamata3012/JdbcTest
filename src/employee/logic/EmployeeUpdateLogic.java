package employee.logic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeUpdateLogic {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:postgresql://127.0.0.1:5432/testdb1";
        String user = "postgres";
        String password = "0413";
        
        String sql="UPDATE employees SET employee_name=?,hire_date=?,department_no=? WHERE employee_no=?";
        	
    	try(Connection con=DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt=con.prepareStatement(sql)){
        	
    		pstmt.setString(1, "河合");
        	pstmt.setDate(2, Date.valueOf("2021-04-01"));
        	pstmt.setString(3, "2");
        	pstmt.setString(4, "7");
        	
        	int count=pstmt.executeUpdate();   
        	
        	if(count==1) {
        		 System.out.println("処理が完了しました");
        	}
        }
	}
}
