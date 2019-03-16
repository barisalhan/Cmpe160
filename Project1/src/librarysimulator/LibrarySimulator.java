package librarysimulator;

import java.util.Scanner;

import books.Book;
import library.Library;
import librarysimulator.Action;
/**
 * 
 * Class that implements the logic for the simulator.
 * In each timerTick one of the possible Actions happen.
 * 
 * @author BarisAlhan
 *
 */
public class LibrarySimulator {
	
	private int tick = 0;
	
	Library library;
	Action action;
	
	public LibrarySimulator() {
		library = new Library();
	}
	
	public void timerTick(Action action) {
		
		tick++;
		
		this.action = action;
		
		if(action.getType()==Action.Type.addBook) {
			library.addBook();
		}
		else if(action.getType()==Action.Type.addMember) {
			library.addMember();
		}
		else if(action.getType()==Action.Type.borrowBook) {
			library.borrowBook();
		}
		else if(action.getType()==Action.Type.returnBook) {
			library.returnBook();
		}
		else if(action.getType()==Action.Type.extendBook) {
			library.extendBook();
		}
		else if(action.getType()==Action.Type.readInLibrary) {
			library.readInLibrary();
		}
		
	}

	public int getTick() {
		return tick;
	}
	
}
