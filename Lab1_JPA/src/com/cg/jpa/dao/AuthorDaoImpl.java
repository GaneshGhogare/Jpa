package com.cg.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.jpa.entity.Author;
import com.cg.jpa.exception.AuthorException;

public class AuthorDaoImpl implements IAuthorDao{

	EntityManager em;
	public AuthorDaoImpl() {
		EntityManagerFactory emf=
				Persistence.createEntityManagerFactory("JPA-PU");
	em= emf.createEntityManager();
	}
	
	public Author addAuthor(Author author) throws AuthorException {
		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();	
		return author;
	}

	public Author getAuthor(int authorId) throws AuthorException{
		Author author= em.find(Author.class, authorId);
		if(author==null)
		{
			throw new AuthorException("Author with entered id not found");
		}
		else
		{
		return author;
		}
	}
	
	public Author updateAuthor(Author author) throws AuthorException{
		em.getTransaction().begin();
		//em.close();
		em.merge(author);
		em.getTransaction().commit();
		return author;
		
	}
	public Author deleteAuthor(int authorId) throws AuthorException{
		em.getTransaction().begin();
	//	em.close();
		Author author= em.find(Author.class, authorId);
		if(author==null)
		{
			throw new AuthorException("Author with entered id not found");
		}
		else {
			em.remove(author);
			em.getTransaction().commit();
		}
		return author;
	}

	public void deleteAuthor(Author author) throws AuthorException {
		em.getTransaction().begin();
		em.remove(author);
		em.getTransaction().commit();
	}
}
