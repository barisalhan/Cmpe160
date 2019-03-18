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
	public void readBook(LibraryMember member) {
		this.setTaken(true);
		this.setWhoTake(member);
		member.addToBookHistory(this);
	}

	@Override
	public void returnBook(LibraryMember member) {
		this.setTaken(false);
		this.setWhoTake(null);
	}
	
	
	
}
