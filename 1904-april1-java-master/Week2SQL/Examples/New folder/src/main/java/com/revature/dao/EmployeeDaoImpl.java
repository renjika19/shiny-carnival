package com.revature.dao;

import static com.revature.util.CloseStreams.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public Boolean insertIntoEmployee(Employee emp) {
		CallableStatement cs = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			cs = conn.prepareCall("{call insertintoemployee(?,?,?)}");
			cs.setString(1, emp.getName());
			cs.setInt(2, emp.getSalary());
			cs.setString(3, emp.getPosition());
			cs.execute();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(cs);
		}
		return true;
	}

}
