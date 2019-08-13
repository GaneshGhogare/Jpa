package com.cg.jpa.service;

import com.cg.jpa.dao.AuthorDaoImpl;
import com.cg.jpa.dao.IAuthorDao;
import com.cg.jpa.entity.Author;
import com.cg.jpa.exception.AuthorException;

public class AuthorServiceImpl implements IAuthorService {

	IAuthorDao dao;
	DataValidator validator;
	public AuthorServiceImpl()
	{
		dao= new AuthorDaoImpl();
		validator= new DataValidator();
	}
	@Override
	public Author addAuthor(Author author) throws AuthorException {
		// TODO Auto-generated method stub
		if(!validator.validateLength(author.getFirstName()))
		{
			throw new AuthorException("FirstName should have length equal or less than 10");
		}
		if(!validator.validateLength(author.getMiddleName()))
		{
			throw new AuthorException("MiddleName should have length equal or less than 10");
		}
		if(!validator.validateLength(author.getLastName()))
		{
			throw new AuthorException("LastName should have length equal or less than 10");
		}
		if(!validator.validateLength(author.getPhoneNo()))
		{
			throw new AuthorException("Phone Number should have length equal to 10");
		}
		return dao.addAuthor(author);
	}

	@Override
	public Author getAuthor(int authorId) throws AuthorException {
		// TODO Auto-generated method stub
		return dao.getAuthor(authorId);
	}

	@Override
	public Author updateAuthor(Author author) throws AuthorException {
		// TODO Auto-generated method stub
		return dao.updateAuthor(author);
	}

	@Override
	public Author deleteAuthor(int authorId) throws AuthorException {
		// TODO Auto-generated method stub
		return dao.deleteAuthor(authorId);
	}

	@Override
	public void deleteAuthor(Author author) throws AuthorException {
		// TODO Auto-generated method stub
		
	}

}
