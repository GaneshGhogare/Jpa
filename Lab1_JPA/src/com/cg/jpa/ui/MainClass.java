package com.cg.jpa.ui;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.jpa.entity.Author;
import com.cg.jpa.exception.AuthorException;
import com.cg.jpa.service.AuthorServiceImpl;
import com.cg.jpa.service.IAuthorService;


public class MainClass {

	public static void main(String[] args) throws AuthorException {
		do
		{	IAuthorService service = new AuthorServiceImpl();
			Scanner sc= new Scanner(System.in);
			int option = 0;
			System.out.println("Enter operations to be performed");
			System.out.println("1)Add author 2) Display author by id 3) Update author");
			System.out.println("4)Delete author by id  5) Exit");
			System.out.println("Select your option");
			try {
				option=sc.nextInt();
			} catch (InputMismatchException e1) {
				// TODO Auto-generated catch block
				System.out.println("please enter a valid intger value");
			}
			
			switch(option)
			{
				case 1:
				try {
					
					Author author=getAllAuthorDetail();
					author=service.addAuthor(author);
					System.out.println("Author added successfully");
					System.out.println(author);
				} catch (AuthorException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					break; 
					
				case 2:
					System.out.println("Enter id of author: ");
					int authorId= sc.nextInt();
				try {
					Author author=service.getAuthor(authorId);
					System.out.println(author);
				} catch (AuthorException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					break;
					
				case 3:
				try {
					System.out.println("Enter author id:");
					int aId=sc.nextInt();
					Author author1=service.getAuthor(aId);
					if(author1!=null)
					{
					Author author=getAllAuthorDetail();
					author.setAuthorId(aId);
					author=service.updateAuthor(author);
					System.out.println("author data updated");
					System.out.println(author);
					}
					else
					{
						System.out.println("No record exist cananot update");
					}
				} catch (AuthorException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					break;
					
				case 4:
					System.out.println("Enter id of author: ");
					int authorID= sc.nextInt();
				try {
					Author author=service.deleteAuthor(authorID);
					System.out.println(author +" deleted");
				} catch (AuthorException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					break;
					
					
				case 5:
					System.exit(0);
					break;
			}
		}while(true);

	}

	private static Author getAllAuthorDetail() {
		Author author = new Author();
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Enter FirstName:");
		String firstName = sc1.next();
		author.setFirstName(firstName);
		
		System.out.println("Enter MiddleName:");
		String middleName = sc1.next();
		author.setMiddleName(middleName);
		
		System.out.println("Enter LastName:");
		String lastName = sc1.next();
		author.setLastName(lastName);
		
		System.out.println("Enter mobileNo");
		String phoneNo= sc1.next();
		author.setPhoneNo(phoneNo);

		return author;
	}

}
