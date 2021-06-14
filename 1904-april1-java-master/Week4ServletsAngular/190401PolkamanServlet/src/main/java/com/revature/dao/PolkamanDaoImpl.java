package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Polkaman;
import com.revature.util.ConnectionUtil;

public class PolkamanDaoImpl implements PolkamanDao{

	@Override
	public Boolean insertPolkaman(Polkaman p) {
		PreparedStatement stmt = null;
		/*
		 * Try-With-Resources
		 * -Any object made with a try with resources block will be
		 * closed automatically for you in the event of a crash, or
		 * successful execution. So you are not required to 
		 * worry about invoking the " .close()" on any objects
		 * created with the try block
		 * -NOTE: requires the object to implement "AutoCloseable"
		 */
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("INSERT INTO polkamans VALUES(?,?,?,?,?)"); 
			//				QUESTION MARL INDEX:					   1 2 3 4 5
			// this is where
			// you would write a line of SQL, but in Java
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getName());
			stmt.setInt(3, p.getHp());
			stmt.setInt(4, p.getStr());
			stmt.setInt(5, p.getOwner_id());
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(stmt);
		}
		return true;
	}

	@Override
	public Polkaman selectPolkamanById(Integer id) {
		Statement stmt = null;
		ResultSet rs = null;
		Polkaman polka = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			stmt = conn.createStatement(); 
			rs= stmt.executeQuery("SELECT * FROM polkamans WHERE p_id ="+id);
			if(rs.next()) {
				polka = new Polkaman(
						rs.getInt("p_Id"), // grab data by name
						rs.getString(2), // or we can grab by index
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5)
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return polka;
	}

	@Override
	public List<Polkaman> selectAllPolkaman() {
		Statement stmt = null;
		ResultSet rs = null;
		List<Polkaman> polkas = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()){
			stmt = conn.createStatement(); // create a statement
			//object from the connection
			//statement objects can exectue sql queries connected
			//to DB
			
			rs = stmt.executeQuery("SELECT * FROM polkamans");
			/*
			 * ResultSet stores all the records from the successful
			 * query
			 */
			while(rs.next()) {
				polkas.add(new Polkaman(
						rs.getInt("p_Id"), // grab data by name
						rs.getString(2), // or we can grab by index
						rs.getInt(3),
						rs.getInt(4),
						rs.getInt(5)
						));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
		}
		return polkas;
	}

	@Override
	public Boolean updatePolkamanById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deletePolkamanById(Integer id) {
		PreparedStatement stmt = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			stmt = conn.prepareStatement("DELETE FROM polkamans WHERE p_id = ?"); 
			stmt.setInt(1, id);
			stmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			close(stmt);
		}
		return true;
	}

}
