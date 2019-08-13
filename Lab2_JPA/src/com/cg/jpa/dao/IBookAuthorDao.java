package com.cg.jpa.dao;

import java.util.List;

import com.cg.jpa.entity.Author;
import com.cg.jpa.entity.Book;
import com.cg.jpa.excpetion.BookAuthorException;

public interface IBookAuthorDao {

	
	public List<Book> getAllBooksDetail() throws BookAuthorException;
	
	public List<Book> getAllBookByOneAuthor(String authorName) throws BookAuthorException;
	
	public List<Book> getAllBookInRange(int startPrice,int endPrice) throws BookAuthorException;
	
	public String getAllAuthorNameByBookId(int isbn) throws BookAuthorException;
	
}


