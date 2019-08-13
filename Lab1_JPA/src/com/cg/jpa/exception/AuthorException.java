package com.cg.jpa.exception;

public class AuthorException extends Exception{
	public AuthorException()
	{
		super("Error occured...");
	}
	public AuthorException(String message)
	{
		super(message);
	}
	
}
