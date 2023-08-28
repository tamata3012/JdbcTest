package main;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UnionSearch {
	
	//データベース接続用
	private Connection con;
	
	//データベース接続
	public UnionSearch(Connection con) {
		this.con=con;
	}

	public void joinSerach() throws SQLException {
		
		String searchsql="SELECT emp.employee_no,emp.employee_name,emp.hire_date,emp.department_no,dep.department_name,dep.location"
	    		+ " FROM employees emp LEFT OUTER JOIN departments dep on emp.department_no=dep.department_no ORDER BY emp.employee_no";
	    
	    try(PreparedStatement pstmt=con.prepareStatement(searchsql)){
	    	
	    	try(ResultSet rs=pstmt.executeQuery()){       		
	    		while(rs.next()) {
	    			System.out.println(
	    					rs.getString(1)+","
	    					+rs.getString(2)+","
	    					+rs.getString(3)+","
	    					+rs.getString(4)+","
	    					+rs.getString(5)+","
	    					+rs.getString(6)
	    					);
	    		}
	    		
	    	} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
	    }
	    
	}

}
