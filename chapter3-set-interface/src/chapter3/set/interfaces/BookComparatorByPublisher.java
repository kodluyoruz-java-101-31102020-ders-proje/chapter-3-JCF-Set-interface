package chapter3.set.interfaces;

import java.util.Comparator;

import chapter3.set.interfaces.model.Book;

public class BookComparatorByPublisher implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		
		// Eeğer o2'nin yılı > o1'den büyükse -1
		
		String book1Publisher = o1.getPublisher();
		String book2Publisher = o2.getPublisher();
		
		return book1Publisher.compareTo(book2Publisher);
	}

}
