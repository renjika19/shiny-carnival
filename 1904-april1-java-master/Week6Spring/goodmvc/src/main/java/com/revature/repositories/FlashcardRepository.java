package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Flashcard;

@Transactional
@EnableTransactionManagement
@Repository
public class FlashcardRepository {
	
	@Autowired
	SessionFactory sf;
	
	public List<Flashcard> getFlashcards() {
		List<Flashcard> flashcards = new ArrayList<Flashcard>();
		Session s = sf.getCurrentSession();
		Criteria cr = s.createCriteria(Flashcard.class);
		flashcards = cr.list();
		return flashcards;
	}
	
	public String persistFlashcard(Flashcard f) {
		Session s = sf.getCurrentSession();
		s.persist(f);
		return "ok";
	}
	
}
