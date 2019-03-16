package librarymembers;


import java.util.ArrayList;

import books.Book;

public class Academic extends LibraryMember{

	private final int maxBooks = 20;
	private final int maxTime = 20;

	public Academic(int id) { 
		super(id);
		maxNumberOfBooks = maxBooks;
		timeLimit = maxTime;
		bookHistory = new ArrayList<Book>();
	}

	@Override
	public int getMaxNumberOfBooks() {
		return maxNumberOfBooks;
	}

	@Override
	public ArrayList<Book> getTheHistory() {
		return bookHistory;
	}

}
