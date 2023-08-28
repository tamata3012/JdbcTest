package employee.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO {
	
	//データベース接続用
	private Connection con;
	
	//データベース接続
	public EmployeeDAO(Connection con) {
		this.con=con;
	}
	
	
	/**
	 * データベース全件検索
	 * @throws SQLException
	 */
	public void searchEmployee() throws SQLException {
		
		String sql="SELECT * FROM employees ORDER BY employee_no ASC ";
		
		 try(PreparedStatement pstmt =con.prepareStatement(sql)){
		     	
		     	try(ResultSet rs=pstmt.executeQuery()){
		     		
		     		while(rs.next()) {
		     			System.out.println(
		     					rs.getString(1)+","
		     					+rs.getString(2)+","
		     					+rs.getString(3)+","
		     					+rs.getString(4)
		     					);
		     			}
		     		
		     	}catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
		     	}
			 }
		
	 }
	
	/**
	 * データベースID条件検索
	 * @throws SQLException
	 */
	public void searchEmployeeById() throws SQLException {
		
		String sql="SELECT * FROM employees WHERE employee_no=? ORDER BY employee_no ASC ";
		
		 try(PreparedStatement pstmt =con.prepareStatement(sql)){
			 
			 pstmt.setString(1, "1");
			 
	     	 try(ResultSet rs=pstmt.executeQuery()){
	     		
	     		while(rs.next()) {
	     			System.out.println(
	     					rs.getString(1)+","
	     					+rs.getString(2)+","
	     					+rs.getString(3)+","
	     					+rs.getString(4)
	     					);
	     			}
	     		
	     	 }catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
	     	}
		 }
	 }
    
    
	
	/**
	 * データベース行挿入
	 * @throws SQLException
	 */
	public void registerEmployee() throws SQLException {
		
		String sql="INSERT INTO employees VALUES(?,?,?,?)";
		
		try(PreparedStatement pstmt=con.prepareStatement(sql)){
        	
        	pstmt.setString(1, "7");
        	pstmt.setString(2, "山口");
        	pstmt.setDate(3, Date.valueOf("2021-04-01"));
        	pstmt.setString(4, "6");
        	pstmt.executeUpdate();   
        }catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
        }
    }
	
	/**
	 * データベース行更新
	 * @throws SQLException
	 */
	public void updateEmployee() throws SQLException {
		
		String sql="UPDATE employees SET employee_name=?,hire_date=?,department_no=? WHERE employee_no=?";
     	
    	try(PreparedStatement pstmt=con.prepareStatement(sql)){
        	
    		pstmt.setString(1, "河合");
        	pstmt.setDate(2, Date.valueOf("2021-04-01"));
        	pstmt.setString(3, "2");
        	pstmt.setString(4, "7");
        	
        	pstmt.executeUpdate();   

        }catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
     	}
		
	}
	
	/**
	 * データベース行削除
	 * @throws SQLException
	 */
	public void deleteEmployee() throws SQLException {
		
		String sql="DELETE FROM employees WHERE employee_no=?";
        
        try(PreparedStatement pstmt=con.prepareStatement(sql)){
        	
    		pstmt.setString(1, "7");
    		pstmt.executeUpdate(); 
    		
        }catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
     	}
	}
}
