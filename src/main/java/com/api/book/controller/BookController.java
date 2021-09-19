package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bookDao.BookDao;
import com.api.book.entities.Book;

@RestController
public class BookController {

	//@Autowired
	//private BookService bookService;

	@Autowired
	private BookDao bookDao;

	@RequestMapping(value = "/allBooks", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getAllBooks(){
		//List<Book> allBooks = this.bookService.getAllBooks();
		List<Book> findAll = null;
		try {
			findAll = this.bookDao.findAll();		
			if (findAll.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.of(Optional.of(findAll));
	}

	@RequestMapping(value = "book/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable("id") int bookId) {
		//Book book = this.bookService.getBook(bookId);
		Book book = null;
		try {
			book = this.bookDao.findById(bookId).get();		
			if(book==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public ResponseEntity<String> insertBook(@RequestBody Book book) {
		//		boolean insertBook = this.bookService.insertBook(book);
		Book save = null;
		String obj = null;
		try {
			save = this.bookDao.save(book);
			if(save==null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			obj = "Added book : "+save.getId()+" Succesfully.";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ResponseEntity.of(Optional.of(obj));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBook(@PathVariable("id") int bookId) {
		//		boolean deleteBook = this.bookService.deleteBook(bookId);
		String obj = null;
		Book book = null;
		try {
			book = this.bookDao.findById(bookId).get();
			if(book==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			this.bookDao.delete(book);
			obj = "Deleted book : "+book.getId()+" Succesfully.";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.of(Optional.of(obj));
	}

}
