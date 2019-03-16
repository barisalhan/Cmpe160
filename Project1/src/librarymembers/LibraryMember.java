package librarymembers;

import java.util.ArrayList;

import books.Book;

public abstract class LibraryMember {
	
	//Arraylist tanimlayip.
	//kendileri kontrol etsinler.
	//SURE siniri olsun, ortak ama farkli gun
	
	int Id;
	int maxNumberOfBooks;
	int timeLimit;
	ArrayList<Book> bookHistory; 
	
	//constructor, sadece id'yi alsin.	
	public LibraryMember(int id) {
		this.Id = id;
	}
	
	//kitap kontrol fonksiyonu
	public abstract ArrayList<Book> getTheHistory();
	
	
	public abstract int getMaxNumberOfBooks();
	
	
}
