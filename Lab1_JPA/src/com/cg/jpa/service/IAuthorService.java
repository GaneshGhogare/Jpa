package com.cg.jpa.service;

import com.cg.jpa.entity.Author;
import com.cg.jpa.exception.AuthorException;

public interface IAuthorService {

	public Author addAuthor(Author author) throws AuthorException;
	public Author getAuthor(int authorId) throws AuthorException;
	public Author updateAuthor(Author author) throws AuthorException;
	public Author deleteAuthor(int authorId) throws AuthorException;
	public void deleteAuthor(Author author) throws AuthorException;
}
