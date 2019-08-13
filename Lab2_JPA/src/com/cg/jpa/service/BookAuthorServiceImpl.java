package com.cg.jpa.service;

import java.util.List;

import com.cg.jpa.dao.BookAuthorDaoImpl;
import com.cg.jpa.dao.IBookAuthorDao;
import com.cg.jpa.entity.Author;
import com.cg.jpa.entity.Book;
import com.cg.jpa.excpetion.BookAuthorException;

public class BookAuthorServiceImpl implements IBookAuthorService {
	IBookAuthorDao dao;
	
	public BookAuthorServiceImpl()
	{
		dao= new BookAuthorDaoImpl();
	}

	@Override
	public List<Book> getAllBooksDetail() throws BookAuthorException {
		// TODO Auto-generated method stub
		return dao.getAllBooksDetail();
	}

	@Override
	public List<Book> getAllBookByOneAuthor(String authorName) throws BookAuthorException {
		// TODO Auto-generated method stub
		return dao.getAllBookByOneAuthor(authorName);
	}

	@Override
	public List<Book> getAllBookInRange(int startPrice, int endPrice) throws BookAuthorException {
		// TODO Auto-generated method stub
		return dao.getAllBookInRange(startPrice, endPrice);
	}

	@Override
	public String getAllAuthorNameByBookId(int isbn) throws BookAuthorException {
		// TODO Auto-generated method stub
		return dao.getAllAuthorNameByBookId(isbn);
	}
	
	

}
