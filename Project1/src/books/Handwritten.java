package books;

import interfaces.ReadInLibrary;
import librarymembers.LibraryMember;

public class Handwritten extends Book
								implements ReadInLibrary{
	
	private final static String bookType = "H";
	
	public Handwritten(int bookId) {
		super(bookId, bookType);
	}

	@Override
	public void readBook(LibraryMember member, Book book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void returnBook() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
