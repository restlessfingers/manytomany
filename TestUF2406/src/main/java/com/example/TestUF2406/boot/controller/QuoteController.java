package com.example.TestUF2406.boot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TestUF2406.boot.model.Quote;
import com.example.TestUF2406.boot.model.Book;
import com.example.TestUF2406.boot.service.QuoteService;
import com.example.TestUF2406.boot.service.BookService;

@Controller
@RequestMapping("/quotes"/*books*/)
public class QuoteController {

	@Autowired
	QuoteService service;
	
	@Autowired
	BookService serviceBook;

	@RequestMapping("/show")
	public String showQuotes(Model model) {

		model.addAttribute("quotes", service.findAll());
		return "books/quotes.html";
	}
	
	
	@RequestMapping("/newQuote")
	public String newQuote(Model model) {

		model.addAttribute("books", serviceBook.findAll());
		return "books/newQuote.html";
	}

	@RequestMapping(value = "/insertQuote", method = RequestMethod.POST)

	public String insertQuote(Quote quote, Model model,
			 @RequestParam("idBook") Long id) {
		
		System.out.println(id);
		
		Optional<Book> foundBook = serviceBook.findById(id);
	
		System.out.println("hola");
		// Search for a book with an invalid ID
		
		if (foundBook.isPresent()) quote.setBook(foundBook.get());
		else quote.setBook(null);
		
		service.insertQuote(quote);
		
		
		model.addAttribute("quotes", service.findAll());
		return "books/library.html";
	}

	/*@RequestMapping("/deleteQuote")
	public String deleteQuote(@RequestParam("title") String tag, Model model) {

		Quote quote = new Quote();

		service.deleteQuote(quote);
		model.addAttribute("library", service.findAll());

		return "quotes/library.html";
	}*/
}