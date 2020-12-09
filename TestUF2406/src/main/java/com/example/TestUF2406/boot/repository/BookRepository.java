package com.example.TestUF2406.boot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.TestUF2406.boot.model.Book;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book,Long> {

	List<Book> findByTitle(String title);

	Optional<Book> findById(long id);
}