package librarymembers;

import java.util.ArrayList;

import books.Book;

public class Student extends LibraryMember {

	private final int maxBooks = 10;
	private final int maxTime = 10;
	
	public Student(int id) {
		super(id);
		maxNumberOfBooks = maxBooks;
		timeLimit = maxTime;
		bookHistory = new ArrayList<Book>();
	}

	@Override
	public ArrayList<Book> getTheHistory() {
		return bookHistory;
	}
	
	@Override
	public int getMaxNumberOfBooks() {
		return maxNumberOfBooks;
	}
		
}
