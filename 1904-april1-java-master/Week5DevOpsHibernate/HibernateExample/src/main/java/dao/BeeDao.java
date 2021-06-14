package dao;

import java.util.List;

import model.Bee;

public interface BeeDao {

	public int insertBee(Bee b);
	public List<Bee> selectAllBee();
	public Bee selectBeeById(int id);
	public void updateBee(Bee change);
	public void deleteBeeById(int id);
}
