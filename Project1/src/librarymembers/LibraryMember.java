package librarymembers;

import java.util.ArrayList;

import books.Book;

public abstract class LibraryMember {
	
	private int Id;
	private int maxNumberOfBooks;
	private int currentNumberOfBooks;
	private int timeLimit;

	private String memberType;
	private boolean isReadInLibrary;

	ArrayList<Book> bookHistory = new ArrayList<Book>(); 
		
	public LibraryMember(int id, String memberType) {
		this.Id = id;
		this.memberType = memberType;
	}
	
	public int getId() {
		return Id;
	}
	
	public int getMaxNumberOfBooks() {
		return maxNumberOfBooks;
	}
	
	public void setMaxNumberOfBooks(int maxNumberOfBooks) {
		this.maxNumberOfBooks = maxNumberOfBooks;
	}

	public int getCurrentNumberOfBooks() {
		return currentNumberOfBooks;
	}
	
	public void setCurrentNumberOfBooks(int currentNumberOfBooks) {
		this.currentNumberOfBooks = currentNumberOfBooks;
	}
	
	public int getTimeLimit() {
		return timeLimit;
	}
	
	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}
	
	public String getMemberType() {
		return memberType;
	}

	public boolean isReadInLibrary() {
		return isReadInLibrary;
	}

	public void setReadInLibrary(boolean isReadInLibrary) {
		this.isReadInLibrary = isReadInLibrary;
	}

	public abstract ArrayList<Book> getTheHistory();

	public abstract void addToBookHistory(Book book);
	
}
