package com.cg.jpa.dao;

import com.cg.jpa.entity.Author;
import com.cg.jpa.exception.AuthorException;

public interface IAuthorDao {

	public Author addAuthor(Author author) throws AuthorException;
	public Author getAuthor(int authorId) throws AuthorException;
	public Author updateAuthor(Author author) throws AuthorException;
	public Author deleteAuthor(int authorId) throws AuthorException;
	public void deleteAuthor(Author author) throws AuthorException;
}
