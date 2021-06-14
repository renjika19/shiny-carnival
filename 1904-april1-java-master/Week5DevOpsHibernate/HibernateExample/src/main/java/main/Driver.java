package main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import dao.BearDaoImpl;
import dao.BeeDaoImpl;
import dao.BeehiveDaoImpl;
import dao.FlowerDaoImpl;
import model.Bear;
import model.Bee;
import model.Beehive;
import model.Flower;
import util.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		
		System.out.println("====APP START====");
		
		Bear b = new Bear("Black Bear", 10);
		BearDaoImpl bd = new BearDaoImpl();
		bd.insertBear(b);		//Testing insertion into database.
		
		List<Bear> bears = bd.selectAllBear(); 	//testing querying the db
		
		System.out.println("====LIST OF BEARS====");
		for(Bear bear : bears) {
			System.out.println(bear);
		}
		
		b.setId(1);
		b.setName("Yogi Bear");
		bd.updateBear(b);
		
		b = new Bear("Brown Bear", 106);
		bd.insertBear(b);
		
		System.out.println("===Updated Bear====");
		System.out.println(bd.selectBearById(1)); 	//testing querying 1 bear
		
		bears = bd.selectAllBear();
		System.out.println("====UPDATED LIST OF BEARS====");
		for(Bear bear : bears) {
			System.out.println(bear);	//testing updated bear
		}
		
		
		Flower f = new Flower(10);
		Flower f2 = new Flower(7);
		
		FlowerDaoImpl fd = new FlowerDaoImpl();
		fd.insertFlower(f);
		fd.insertFlower(f2);	//testing insertion.
		List<Flower> flowers = new ArrayList<Flower>();
		flowers.add(f);
		flowers.add(f2);
		
		Beehive bh = new Beehive(100);
		BeehiveDaoImpl bhd = new BeehiveDaoImpl();
		bhd.insertBeehive(bh);
		
		Bee bee = new Bee(100,bh);
		bee.setFlowers(flowers);
		BeeDaoImpl beed = new BeeDaoImpl();
		beed.insertBee(bee);
		
		Bee bee2 = new Bee(125,bh);
		bee.setFlowers(flowers);
		beed.insertBee(bee2);
		
		/*
		 * Criteria and Query
		 * 
		 * Criteria and query are both interfaces of hibernate.
		 * Objects of these types can be made using the session.
		 * They both server similar purposes; they are both used
		 * to grab data from the database, just in different ways.
		 * 
		 * query uses HQL or SQL.
		 */
		
		Query query;
		Session session = HibernateUtil.getSession();
		System.out.println("==========GET ALL BEES========");
		String hql = "FROM Bee";
		query = session.createQuery(hql);
		System.out.println(query.list());	//GET ALL THE BEES
		
		System.out.println("===Parameterized HQL======");
		
		hql = "FROM Bee WHERE id = :id";	//The colon parameterizes the HQL
		query = session.createQuery(hql);
		query.setParameter("id", 50);
		System.out.println(query.uniqueResult());
		
		/*
		 * Criteria is an object based approach to grabbing
		 * a value from the database.
		 * 
		 * Instead of using one of the query languages, the
		 * criteria interface can grab values from the database
		 * using what is called 'criteria'.
		 */
		
		System.out.println("====Criteria Get All====");
		
		List<Bee> bees;
		
		bees = session.createCriteria(Bee.class).list();
		//grabs all the records from the db that are from
		//the Bee class.
		
		System.out.println(bees);
		Criteria crit = session.createCriteria(Bee.class);
		crit.add(Restrictions.idEq(50));
		
		System.out.println(crit.uniqueResult());
		
		Criteria crit2 = session.createCriteria(Flower.class);
		crit2.setProjection(Projections.sum("petals"));
//		List<Flower> flowerlist = crit2.list();
//		System.out.println("The total number of petals is: " 
//				+ flowerlist.get(0));
		System.out.println("The total number of petals is: " 
				+ crit2.uniqueResult());
		
		
		//Hibernate can use Native SQL
		String sql = "SELECT * FROM Flower WHERE f_petals > :value";
		SQLQuery squery = session.createSQLQuery(sql);
		squery.addEntity(Flower.class);
		squery.setParameter("value", 8);
		System.out.println(squery.uniqueResult());
	}
	
}
