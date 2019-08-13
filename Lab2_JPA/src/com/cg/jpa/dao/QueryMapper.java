package com.cg.jpa.dao;

public class QueryMapper {

	
	public static final String FETCH_ALL_BOOK_DETAIL="select book from Book book";
	
	public static final String FETCH_ALL_BOOK_BY_AUTHOR="select book from Book book where book.author.name=:name";
	
	public static final String FETCH_ALL_BOOK_BETWEEN_PRICE="select book from Book book where book.price>=:startPrice and book.price<=:endPrice";

	public static final String FETCH_BOOK_AUTHOR_NAME="select book.author.name from Book book where book.isbn=:id";
}
