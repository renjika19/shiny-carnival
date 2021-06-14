package com.revature.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Flashcard;
import com.revature.services.FlashcardService;

@Controller
@RequestMapping("/flashcard")
public class FlashcardController {

	@Autowired
	FlashcardService fs;

	// this works the same way
	// @GetMapping("/all")
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Flashcard>> getAllFlashcards() {
		return new ResponseEntity<>(fs.getFlashcards(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Flashcard> getFlashcardById(@PathVariable int id) {
		return new ResponseEntity<Flashcard>(fs.getById(id), HttpStatus.OK);
	}

	@GetMapping(value = "/most")
	@ResponseBody
	public List<Flashcard> getMostFlashcards() {
		List<Flashcard> flashcards = fs.getFlashcards();
		flashcards.remove(0);
		return flashcards;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	@ResponseBody
	public String handleFormAdd(@RequestBody MultiValueMap<String, String> formParams) {
		System.out.println("form params received: " + formParams);
		Flashcard f = new Flashcard(0, formParams.getFirst("question"), formParams.getFirst("answer"));
		try {
			fs.addFlashcard(f);
			//DO NOT DO:
			return "<a href='/goodmvc/flashcard/formAdd'>Link</a><script>console.log('wut')</script>";
		} catch (Exception e) {
			return "Flashcard Creation Failed! :( ";
		}
	}
	
	@RequestMapping(value = "/addJSON", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String handleJSONAdd(@RequestBody @Valid Flashcard flashcard, Errors errors) {
		if (errors.hasErrors()) {
			for (ObjectError e : errors.getAllErrors()) {
				System.err.println(e);
			}
			return "Flashcard Not Valid! :( ";
		}
		try {
			fs.addFlashcard(flashcard);
			return "Flashcard Created!";
		} catch (Exception e) {
			return "Flashcard Creation Failed! :( ";
		}
	}
	
	@GetMapping("/formAdd")
	public String redirectToForm() {
		return "redirect:/static/index.html";
	}

}
