package department.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDAO {

	//データベース接続用
	private Connection con;
	
	//データベース接続
	public DepartmentDAO(Connection con) {
		this.con=con;
	}
	
	/**
	 * データベース全件検索
	 * @throws SQLException
	 */
	public void searchDepartment() throws SQLException {
		
		String sql="SELECT * FROM departments ORDER BY department_no ASC ";
	    
	    try(PreparedStatement pstmt=con.prepareStatement(sql)){
	    	
	    	try(ResultSet rs=pstmt.executeQuery()){
	    		
	    		while(rs.next()) {
	    			System.out.println(
	    					rs.getString(1)+","
	    					+rs.getString(2)+","
	    					+rs.getString(3)
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
	public void searchDepartmentByName() throws SQLException {
		
		String sql="SELECT * FROM departments WHERE department_name=? ORDER BY department_no ASC ";
	    
	    try(PreparedStatement pstmt=con.prepareStatement(sql)){
	    	
	    	pstmt.setString(1, "開発部");
	    	
	    	try(ResultSet rs=pstmt.executeQuery()){
	    		
	    		while(rs.next()) {
	    			System.out.println(
	    					rs.getString(1)+","
	    					+rs.getString(2)+","
	    					+rs.getString(3)
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
	public void registerDepartment() throws SQLException {
		
		String sql="INSERT INTO departments VALUES(?,?,?)";
        
        
        try(PreparedStatement pstmt=con.prepareStatement(sql)){
        	
        	pstmt.setString(1, "6");
        	pstmt.setString(2, "開発部");
        	pstmt.setString(3, "名古屋");
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
	public void updateDepartment() throws SQLException {
		
		String sql="UPDATE departments SET department_name=?,location=? WHERE department_no=?";
    	
        	try(PreparedStatement pstmt=con.prepareStatement(sql)){
        	
    		pstmt.setString(1, "関連開発部");
        	pstmt.setString(2, "大阪");
        	pstmt.setString(3, "6");
        	
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
	public void deleteDepartment() throws SQLException {
		 String sql="DELETE FROM departments WHERE department_no=?";
	        
	        try(PreparedStatement pstmt=con.prepareStatement(sql)){
	        	
	    		pstmt.setString(1, "6");
	        	pstmt.executeUpdate();   
	        	
	        }catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	}
}
