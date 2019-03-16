package library;


import java.util.ArrayList;
import java.util.Scanner;

import books.*;
import librarymembers.*;
/**
 * 
 * Class that represents the Management System of Library.
 * Action requests are come from LibrarySimulator the Library class
 * and in here, ALL THE POSSIBLE ERRONEOUS ACTIONS MUST BE CHECKED.
 * 
 * @author BarisAlhan
 *
 */
public class Library {
	
	Scanner sc = new Scanner(System.in);
	
	//library'de check edilmesi lazim.
	
	private ArrayList<Book> books;
	private ArrayList<LibraryMember> members;
	
	public Library() {
		books = new ArrayList<>();
		members = new ArrayList<>();
	}
	
	//Okumayi burada yapiyoruz.
	public void addBook() {
		int book_id = sc.nextInt();
		String book_type = sc.next();
		if(book_type=="P") {
			Printed book = new Printed(book_id);
			books.add(book);
		}
		else {
			Handwritten book = new Handwritten(book_id);
			books.add(book);
		}
	}
	public void addMember() {
		int member_id = sc.nextInt();
		String member_type = sc.next();
		if(member_type == "S") {
			Student member = new Student(member_id);
			members.add(member);
		}
		else {
			Academic member = new Academic(member_id);
			members.add(member);
		}
	}
	public void borrowBook() {
		int book_id = sc.nextInt();
		int member_id = sc.nextInt();
		if(checkBorrow(book_id,member_id)) {
			
		}
	}
	public void returnBook() {
		
		
	}
	public void extendBook() {
		
		
	}
	public void readInLibrary() {
		
		
	}
	
	public boolean checkBorrow(int book_id, int member_id) {
		//it must be implemented
		return true;
	}
	
	
}
