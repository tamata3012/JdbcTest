package employee.logic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeRegisterLogic {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:postgresql://127.0.0.1:5432/testdb1";
        String user = "postgres";
        String password = "0413";
        
        String sql="INSERT INTO employees VALUES(?,?,?,?)";
        
        
        try(Connection con=DriverManager.getConnection(url, user, password);
        		PreparedStatement pstmt=con.prepareStatement(sql)){
        	
        	pstmt.setString(1, "1");
        	pstmt.setString(2, "山口");
        	pstmt.setDate(3, Date.valueOf("2021-04-01"));
        	pstmt.setString(4, "6");
        	int count=pstmt.executeUpdate();   
        	
        	if(count==1) {
        		 System.out.println("処理が完了しました");
        	}
        	
		}
	}
}
