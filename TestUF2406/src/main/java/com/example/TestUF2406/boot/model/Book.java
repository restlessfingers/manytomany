package com.example.TestUF2406.boot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Getter @Setter
@Entity

@Table(name = "BOOK")
@NamedQueries({ @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
@NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b") })

public class Book {
	// ...
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;


	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY,
          cascade = CascadeType.ALL)
	 @JsonIgnore
	private List<Quote> quotes;

	protected Book() {}

	public Book(Long id, String title) {
		this.id = id;
		this.title = title;
	}

	
	/*public Book(String title) {
		this.title = title;
	}*/

	@Override
	public String toString() {
		return String.format("Book[id=%d, id='%s', title='%s']", id, title);
	}


	public List<Quote> getQuote() {
		return quotes;
	}
	
	  public void setQuote(List<Quote> quotes) { 
		  this.quotes = quotes; }
	 
}