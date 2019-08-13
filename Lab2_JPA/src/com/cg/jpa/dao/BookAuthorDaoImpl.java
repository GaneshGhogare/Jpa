package com.cg.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.jpa.entity.Author;
import com.cg.jpa.entity.Book;
import com.cg.jpa.excpetion.BookAuthorException;

public class BookAuthorDaoImpl implements IBookAuthorDao {


	EntityManager em;
	public BookAuthorDaoImpl() {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("JPA-PU");
		em= emf.createEntityManager();
	}
	@Override
	public List<Book> getAllBooksDetail() throws BookAuthorException {
		// TODO Auto-generated method stub
		TypedQuery<Book> tq=em.createQuery(QueryMapper.FETCH_ALL_BOOK_DETAIL,Book.class);
		List<Book> bookList= tq.getResultList();
		if(bookList.isEmpty())
		{
			throw new BookAuthorException("No books exist in table");
		}
		else
		{
			return bookList;
		}}
	
	@Override
	public List<Book> getAllBookByOneAuthor(String authorName) throws BookAuthorException {
		// TODO Auto-generated method stub
		TypedQuery<Book> tq=em.createQuery(QueryMapper.FETCH_ALL_BOOK_BY_AUTHOR,Book.class);
		tq.setParameter("name",authorName);
		List<Book> bookListByOneAuthor= tq.getResultList();
		if(bookListByOneAuthor.isEmpty())
		{
			throw new BookAuthorException("No books exist with given author name");
		}
		else
		{
			return bookListByOneAuthor;
		}
	}
	@Override
	public List<Book> getAllBookInRange(int startPrice, int endPrice) throws BookAuthorException {
		// TODO Auto-generated method stub
		TypedQuery<Book> tq=em.createQuery(QueryMapper.FETCH_ALL_BOOK_BETWEEN_PRICE,Book.class);
		tq.setParameter("startPrice", startPrice);
		tq.setParameter("endPrice", endPrice);
		List<Book> bookListInRange= tq.getResultList();
		if(bookListInRange.isEmpty())
		{
			throw new BookAuthorException("No books exist within given range");
		}
		else
		{
			return bookListInRange;
		}
	}
	@Override
	public String getAllAuthorNameByBookId(int isbn) throws BookAuthorException {
		// TODO Auto-generated method stub
		Book book = em.find(Book.class,isbn);
		String author = book.getAuthor().getName();
		
		if(author.equals(null))
		{
			throw new BookAuthorException("please enter a valid isbn");
		}
		else
		{
			return author;
		}
	}

}
