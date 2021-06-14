package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Flashcard;
import com.revature.repositories.FlashcardRepository;

@Service
public class FlashcardService {
	
	@Autowired
	FlashcardRepository fr;
	
	public List<Flashcard> getFlashcards() {
		
		List<Flashcard> flashcards = new ArrayList<Flashcard>();
		//typical behaviour
		return fr.getFlashcards();
	}
	
	public Flashcard getById(int id) {
		List<Flashcard> flashcards = fr.getFlashcards();
		for (Flashcard f : flashcards) {
			if (id == f.getId()) {
				return f;
			}
		}
		return null;
	}
	
	public void addFlashcard(Flashcard f) {
		//typical behaviour
		fr.persistFlashcard(f);
	}
	
}
