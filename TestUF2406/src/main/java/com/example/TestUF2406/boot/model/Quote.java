package com.example.TestUF2406.boot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Quote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String tag;
	private String sentence;
	private int numberWords;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOK_ID_FK", nullable = true)
	@JsonIgnore
	private Book book;
	
	public Quote() {}
	
	
	public Quote(int id, String tag, String sentence, int numberWords, Book book) {
		super();
		this.id = id;
		this.tag = tag;
		this.sentence = sentence;
		this.numberWords = numberWords;
	}

	@Override
	public String toString() {
		return "Id [id=" + id + ", tag=" + tag + ", sentence=" + sentence
				+ ", numberWords=" + numberWords + "]";
	}

	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}