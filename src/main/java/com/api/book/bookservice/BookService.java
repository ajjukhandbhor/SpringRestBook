package com.api.book.bookservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.book.entities.Book;

@Service
public class BookService {

	private static List<Book> list = new ArrayList<Book>();

	static {
//		list.add(new Book(1, "My Dream", "Ajay"));
//		list.add(new Book(2, "Java", "Sun MicroSystem"));
//		list.add(new Book(3, "Python", "Ajay Khandbhor"));
	}

	public List<Book> getAllBooks(){		
		return list;
	}

	public Book getBook(int bookId) {
		Book book = list.stream().filter(id ->id.getId()==bookId).findFirst().get();
		return book;
	}

	public boolean insertBook(Book book) {
		boolean insertBook = list.add(book);
		return insertBook;
	}

	public boolean deleteBook(int bookId) {
		Book book = list.stream().filter(id ->id.getId()==bookId).findFirst().get();		
		boolean remove = list.remove(book);
		//		list.stream().filter(b->{
		//			if(b.getId()!=bookId) {
		//				return true;
		//			}
		//			else
		//			{
		//				return false;
		//			}
		//		}).collect(Collectors.toList());
		return remove;
	}

}
