package librarymembers;

import java.util.ArrayList;

import books.Book;

public class Student extends LibraryMember {

	private final int maxBooks = 10;
	private final int maxTime = 10;

	private final static String memberType = "S";
	
	public Student(int id) {
		super(id,memberType);
		setMaxNumberOfBooks(maxBooks);
		setTimeLimit(maxTime);
	}

	@Override
	public ArrayList<Book> getTheHistory() {
		return bookHistory;
	}

	@Override
	public void addToBookHistory(Book book) {
		this.bookHistory.add(book);
	}
	
	public int getMaxBooks() {
		return maxBooks;
	}

	public int getMaxTime() {
		return maxTime;
	}
		
}
