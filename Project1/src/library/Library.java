package library;

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
	
	public int BOOK_ID = 1;
	public int MEMBER_ID = 1;
	
	public int totalFee = 0;
	
	//**
	Scanner sc = new Scanner(System.in);
	
	private Book[] books;
	private LibraryMember[] members;
	
	public Library() {
		books = new Book[1000000];
		members = new LibraryMember[1000000];
	}
	
	public void addBook() {
		int book_id = BOOK_ID++;
		String book_type = sc.next();
		if(book_type=="P") {
			Printed book = new Printed(book_id);
			books[book_id] = book;
		}
		else {
			Handwritten book = new Handwritten(book_id);
			books[book_id] = book;
		}
	}
	
	public void addMember() {
		int member_id = MEMBER_ID++;
		String member_type = sc.next();
		if(member_type == "S") {
			Student member = new Student(member_id);
			members[member_id] = member;
		}
		else {
			Academic member = new Academic(member_id);
			members[member_id] = member;
		}
	}
	
	public void borrowBook(int tick) {
		int book_id = sc.nextInt();
		int member_id = sc.nextInt();
		if(checkBorrow(book_id,member_id)) {
			//Referans olarak mi type cast yapiyor?
			Printed printed = (Printed) books[book_id];  
			printed.borrowBook(members[member_id], tick);
		}
	}
	
	public void returnBook(int tick) {
		int book_id = sc.nextInt();
		int member_id = sc.nextInt();
		if(checkReturn(book_id,member_id)) {
			
			if(books[book_id].getBookType() == "P") {
				Printed printed = (Printed)books[book_id];
				if(printed.getDeadLine() > tick) {
					payFee(printed,tick);
				}
				printed.returnBook(members[member_id]);
			}
			
			else {
				Handwritten handwritten= (Handwritten)books[book_id];
				handwritten.returnBook(members[member_id]);
			}
			
		}
	}
	
	public void extendBook(int tick) {
		int book_id = sc.nextInt();
		int member_id = sc.nextInt();
		if(checkExtend(members[member_id], books[book_id], tick)) {
			Printed printed = (Printed)books[book_id];
			printed.extend(members[member_id], tick);
		}
	}
	
	public void readInLibrary() {
		int book_id = sc.nextInt();
		int member_id = sc.nextInt();
		if(checkReadInLibrary(members[member_id],books[book_id])) {
			if(books[book_id].getBookType()=="H") {
				Handwritten handwritten = (Handwritten)books[book_id];
				handwritten.readBook(members[member_id]);
			}
			else{
				Printed printed = (Printed) books[book_id];
				printed.readBook(members[member_id]);
			}
		}
	}
	
	public boolean checkBorrow(int book_id, int member_id) {
		return true;
	}
	
	public boolean checkReturn(int book_id, int member_id) {
		return true;
	}
	
	public boolean checkExtend(LibraryMember member, Book book, int tick) {
		return true;
	}
	
	public boolean checkReadInLibrary(LibraryMember member, Book book) {
		return true;
	}
	
	public void payFee(Printed printed, int tick) {
		totalFee += printed.getDeadLine() - tick;
	}
	
}
