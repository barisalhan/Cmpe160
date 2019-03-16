package books;

public abstract class Book {
	
	///bir tane kitap var.
	//Borrow edilmisse kim borrow etmis,
	//kisinin de hangi kitaplari aldigini tutaalim.
	
	private int bookID;
	private String bookType;
	private boolean isTaken;
	private String whoTake;
	
	//super i cagirmak icin burada constructor kodla.
	public Book(int bookId, String bookType) {
		this.bookID = bookId;
		this.bookType = bookType;
	}
	
	public abstract void returnBook();
	//return book'u abstract method olarak vereyim.

	
	//getter,setter
	public int getBookID() {
		return bookID;
	}

	public String getBookType() {
		return bookType;
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

	public String getWhoTake() {
		return whoTake;
	}

	public void setWhoTake(String whoTake) {
		this.whoTake = whoTake;
	}
		
}
