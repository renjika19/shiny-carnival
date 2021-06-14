package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Owner;
import com.revature.util.ConnectionUtil;

public class OwnerDaoImpl implements OwnerDao{
	private final static Logger logger = Logger.getLogger(OwnerDaoImpl.class);

	@Override
	public Owner selectOwnerById(Integer id) {
		Owner own = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			ps = conn.prepareStatement("SELECT * FROM owners WHERE c_id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()){
				own = new Owner(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5)
						);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		return own;
	}

	@Override
	public Boolean insertOwner(Owner own) {
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()){
		
			ps = conn.prepareStatement("INSERT INTO owners VALUES((select max(o_id) from owners)+1,?,1000,?,?)");
		
			ps.setString(1, own.getName());
			ps.setString(2, own.getUsername());
			ps.setString(3, own.getPassword());

			ps.executeQuery();
			logger.info("New owner insert SUCCESS on user: " + own.getUsername());

			return true;
			
		}catch(SQLException e){
			e.printStackTrace();

			logger.error("New owner insert FAILED on user: " + own.getUsername());
			
		}finally{

			close(ps);
		}

		
		return false;
	}



	@Override
	public Owner selectOwnerByUsername(String username) {
		Owner own = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			ps = conn.prepareStatement("SELECT * FROM owners WHERE LOWER(o_username) = ?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			while(rs.next()){
				own = new Owner(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getString(4),
							rs.getString(5)
						);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		return own;
	}

	@Override
	public List<Owner> selectAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
}
