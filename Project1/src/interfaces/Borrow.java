package interfaces;

import books.Book;
import librarymembers.LibraryMember;

public interface Borrow {
	
	public void borrowBook(LibraryMember member,Book book);
	public void extend(LibraryMember member);
	public void payFee(LibraryMember member);//cezasi varsa yeni kitap alamasin.
	
}
