package librarymembers;


import java.util.ArrayList;

import books.Book;

public class Academic extends LibraryMember{

	private final int maxBooks = 20;
	private final int maxTime = 20;

	private final static String memberType = "A";
	
	public Academic(int id) { 
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

}
