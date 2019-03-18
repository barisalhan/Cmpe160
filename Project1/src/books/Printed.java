package books;

import interfaces.Borrow;
import interfaces.ReadInLibrary;
import librarymembers.LibraryMember;

public class Printed extends Book
						implements Borrow,ReadInLibrary{
	
	private final static String bookType = "P";
	
	private int deadLine;
	private boolean isExtended = false;
	
	public Printed(int bookId)
	{
		super(bookId, bookType);
	}

	@Override
	public void readBook(LibraryMember member) {
		this.setTaken(true);
		this.setWhoTake(member);
		member.addToBookHistory(this);
	}
	
	@Override
	public void borrowBook(LibraryMember member, int tick) {
		this.setTaken(true);
		this.setWhoTake(member);
		this.setDeadLine(member.getTimeLimit() + tick);
		member.addToBookHistory(this);
		member.setCurrentNumberOfBooks(member.getCurrentNumberOfBooks()+1);
	}

	@Override
	public void extend(LibraryMember member, int tick) {
		this.setExtended(true);
		this.setDeadLine(member.getTimeLimit() + tick);
	}
	
	@Override
	public void returnBook(LibraryMember member) {
		this.setTaken(false);
		//THESE LINES MAY BE EXPLAINED IN THE DOCUMENT CAREFULLY!
		this.setWhoTake(null);
		this.setDeadLine(0);
		this.setExtended(false);
		member.setCurrentNumberOfBooks(member.getCurrentNumberOfBooks()-1);
	}

	public boolean isExtended() {
		return isExtended;
	}

	public void setExtended(boolean isExtended) {
		this.isExtended = isExtended;
	}
	

	public int getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}
	
}
