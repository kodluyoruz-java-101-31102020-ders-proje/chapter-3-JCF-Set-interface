package chapter3.set.interfaces;

import java.util.Comparator;

import chapter3.set.interfaces.model.Book;

public class BookComparatorByPublishYear implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		
		int book1PublishYear = o1.getPublishYear();
		int book2PublishYear = o2.getPublishYear();
		
		
		// Integer.compare(book1PublishYear, book2PublishYear);
		
		if(book2PublishYear > book1PublishYear) {
			return -1;
		}
		else if(book1PublishYear > book2PublishYear) {
			return 1;
		}
		else {
			
			double book1Price = o1.getPrice();
			double book2Price = o2.getPrice();

			if(book2Price > book1Price) {
				return 1;
			}
			else if(book1Price > book2Price) {
				return -1;
			}
			
			return 0;
		}
		
	}

	
	
}
