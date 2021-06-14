package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Bear;
import util.HibernateUtil;

public class BearDaoImpl implements BearDao {

	@Override
	public int insertBear(Bear b) {
		Session session = HibernateUtil.getSession(); //Connect to db
		Transaction tx = null;
		int id = 0;
		
		try {
			tx = session.beginTransaction();	//Open the transaction block
			id = (int) session.save(b); 	//Persist the object to the DB
			//When you insert, save() returns the generated ID for the record
			//you inserted.
			tx.commit();	//Finalize the insert.
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();		//In the event on and error, 
								//delete all traces of the transaction.
		} finally {
			session.close();	//ALWAYS close your sessions!!!!
		}
		
		return id;
	}

	@Override
	public List<Bear> selectAllBear() {
		Session session = HibernateUtil.getSession();
		List<Bear> bears = null;
		
		//Notice that you do not need to use Transaction when you are
		//simply querying the DB.
		try {
			//HQL is still Java based, select from the class name, not table name
			bears = session.createQuery("FROM Bear").list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bears;
	}
	
	/*
	 * Hibernate Object States
	 * 
	 * There are 3 different object states in hibernate. These objects are
	 * part of the Hibernate architecture.
	 * 
	 * Transient - 
	 * 		- an object is transient if it has been instantiated using the 'new'
	 * 		operator and is not associated with a Hibernate Session.
	 * 		- Transient instances will be destroyed by the garbage collector
	 * 		if the application does not hold a reference anymore.
	 * 
	 * Persistent -
	 * 		- an object is persistent if it has representation in the database
	 * 		and an identifier value.
	 * 		- It is in the scope of a session.
	 * 		- Hibernate will detect changes made to an object in persistent
	 * 		state and synchronize the state with the database when the unit
	 * 		of work completes.
	 * 		- Use methods such as save() or persist() if you want to make a
	 * 		persistent object.
	 * 
	 * Detached -
	 * 		- an object is detached if it was persistent, but its session
	 * 		 has closed.
	 * 		- The reference to the object is still valid and the detached 
	 * 		instance might even be modified in that state.
	 * 		- A detached instance can be re-attached to a new session at a later
	 * 		point in time, making it persistent again.
	 */
	public Bear selectBearById(int id) {
		Session session = HibernateUtil.getSession();
		Bear bear = null;	//The object is TRANSIENT
		
		try {
			bear = (Bear) session.get(Bear.class, id);//The object is PERSISTENT
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();	//The object is DETACHED
		}
		return bear;
	}
	
	@Override
	public void updateBear(Bear change) {
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		Bear bear = null;
		
		try {
			tx = session.beginTransaction();
			bear = (Bear) session.get(Bear.class, change.getId());
			if(change.getName() != null) {
				bear.setName(change.getName());
			}
			bear.setAge(change.getAge());
			
			session.save(bear);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	@Override
	public void deleteBearById(int id) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(session.get(Bear.class, id));
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
