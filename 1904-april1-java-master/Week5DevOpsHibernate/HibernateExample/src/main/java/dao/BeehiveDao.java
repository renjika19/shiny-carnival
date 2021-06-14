package dao;

import java.util.List;

import model.Beehive;

public interface BeehiveDao {
	
	public int insertBeehive(Beehive b);
	public List<Beehive> selectAllBeehive();
	public Beehive selectBeehiveById(int id);
	public void updateBeehive(Beehive change);
	public void deleteBeehiveById(int id);
}
