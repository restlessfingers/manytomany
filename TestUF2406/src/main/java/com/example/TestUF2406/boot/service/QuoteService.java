package com.example.TestUF2406.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TestUF2406.boot.model.Quote;
import com.example.TestUF2406.boot.repository.QuoteRepository;


@Service
public class QuoteService {

	@Autowired
	QuoteRepository repository;
	
	
	public Iterable<Quote> findAll() {
		
		//return com.example.repository.findAll();
		return repository.findAll();
	}
	
	public void insertQuote(Quote quote) {
		
		repository.save(quote);
	}
	
	public void deleteQuote(Quote quote) {
		
		repository.delete(quote);
	}

}