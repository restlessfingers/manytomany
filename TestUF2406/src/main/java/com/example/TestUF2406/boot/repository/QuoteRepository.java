package com.example.TestUF2406.boot.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.TestUF2406.boot.model.Quote;


public interface QuoteRepository extends CrudRepository<Quote,Long> {
	Quote findById(long id);
	
}