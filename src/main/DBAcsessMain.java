package main;

import java.sql.Connection;

import department.dao.DepartmentDAO;
import employee.dao.EmployeeDAO;

public class DBAcsessMain {

	/**
	 * DAOの各SQLをそれぞれ実行する
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		try (Connection con=ConnectionManager.getConnection();){
			
			EmployeeDAO empdao=new EmployeeDAO(con);
			DepartmentDAO depdao=new DepartmentDAO(con);
			UnionSearch uni=new UnionSearch(con);
			
			System.out.println("--Employee表全件検索--");
			empdao.searchEmployee();
			
			System.out.println();
			
			System.out.println("--Employee表id条件検索--");
			empdao.searchEmployeeById();
			
			System.out.println();
			
			System.out.println("--Employee表行追加--");
			empdao.registerEmployee();
			empdao.searchEmployee();
			
			System.out.println();
			
			System.out.println("--Employee表行更新--");
			empdao.updateEmployee();
			empdao.searchEmployee();
			
			System.out.println();
			
			System.out.println("--Employee表行削除--");
			empdao.deleteEmployee();
			empdao.searchEmployee();
			
			System.out.println();
			
			System.out.println("--Department表全件検索--");
			depdao.searchDepartment();
			
			System.out.println();
			
			System.out.println("--Department表部署名条件検索--");
			depdao.searchDepartmentByName();
			
			System.out.println();
			
			System.out.println("--Department表行追加--");
			depdao.registerDepartment();
			depdao.searchDepartment();
			
			System.out.println();
			
			System.out.println("--Department表行更新--");
			depdao.updateDepartment();
			depdao.searchDepartment();
			
			System.out.println();
			
			System.out.println("--Department表行削除--");
			depdao.deleteDepartment();
			depdao.searchDepartment();
			
			System.out.println();
			
			System.out.println("--表結合全件検索--");
			uni.joinSerach();
		}
	}

}
