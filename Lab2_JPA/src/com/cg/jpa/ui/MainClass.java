package com.cg.jpa.ui;

import java.util.List;
import java.util.Scanner;

import com.cg.jpa.entity.Book;
import com.cg.jpa.excpetion.BookAuthorException;
import com.cg.jpa.service.BookAuthorServiceImpl;
import com.cg.jpa.service.IBookAuthorService;

public class MainClass {

	public static void main(String[] args) throws BookAuthorException {
		do
		{	Scanner sc= new Scanner(System.in);
			IBookAuthorService service=new BookAuthorServiceImpl();
			System.out.println("Enter your option");
			System.out.println("1)Query all books");
			System.out.println("2)Query all books written by given author name");
			System.out.println("3)Query all books in particular price range");
			System.out.println("4)Query author Name by book id");
			System.out.println("5)Exit");
			int option=sc.nextInt();
			switch(option)
			{
				case 1:
				try {
					List<Book> bookList=service.getAllBooksDetail();
					System.out.println("Book Details:");
					System.out.println(bookList);
				} catch (BookAuthorException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					break;
				case 2:
				try {
					System.out.println("Enter authorName:");
					String authorName=sc.next();
					List<Book> bookByAuthor=service.getAllBookByOneAuthor(authorName);
					System.out.println("Book Details:");
					System.out.println(bookByAuthor);
				} catch (BookAuthorException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					break;
				case 3:
					System.out.println("Enter starting price range");
					int startPrice=sc.nextInt();
					System.out.println("Enter ending price range");
					int endPrice=sc.nextInt();
				try {
					List<Book> bookByPriceRange=service.getAllBookInRange(startPrice, endPrice);
					System.out.println("Book Details:");
					System.out.println(bookByPriceRange);
				} catch (BookAuthorException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					break;
				case 4:
					System.out.println("Enter book isbn");
					int isbn= sc.nextInt();
				try {
					String authorName=service.getAllAuthorNameByBookId(isbn);
					System.out.println("Book isbn: "+isbn);
					System.out.println("Author Name :"+authorName);
				} catch (BookAuthorException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
					
					break;
				case 5:
					System.exit(1);
				default:
					System.out.print("Invalid option entered");
					break;
			}
		}while(true);

	}

}
