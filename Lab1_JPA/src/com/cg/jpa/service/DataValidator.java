package com.cg.jpa.service;

public class DataValidator {


	public boolean validateLength(String authorDetail)
	{
		if(authorDetail.length()<=10)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	
	
}
