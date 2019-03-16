package books;

import interfaces.Borrow;
import interfaces.ReadInLibrary;
import librarymembers.LibraryMember;

public class Printed extends Book
						implements Borrow,ReadInLibrary{
	
	private final static String bookType = "P";
	
	public Printed(int bookId)
	{
		super(bookId, bookType);
	}

	@Override
	public void readBook(LibraryMember member, Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrowBook(LibraryMember member, Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void extend(LibraryMember member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void payFee(LibraryMember member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnBook() {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
}
