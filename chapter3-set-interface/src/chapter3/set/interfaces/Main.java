package chapter3.set.interfaces;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import chapter3.set.interfaces.model.Book;

public class Main {

	public static void main(String[] args) {
		
		//runHashSetSample();
		
		//runBookSample();
		
		//runTreeSetSamples();
		
		runTreeSetSamples();
	}
	
	public static void runHashSetSample() {
		
		
		// ********* EnumSet Örneği *********
		// EnumSet sadece enum tipte veriler kabul eder ve null değer almaz!
		Set<PaymentStatus> enumSet = EnumSet.of(PaymentStatus.SUCCESS, PaymentStatus.FAIL);
		enumSet.add(PaymentStatus.PROVISION);
		enumSet.add(PaymentStatus.PROVISION);
		
		for(PaymentStatus s : enumSet) {
			System.out.println(s);
		}
		// ********* EnumSet Örneği *********
		
		
		// ********* HashSet Örneği *********
		// HashSet örneğini String tipinde hazır veri tipiyle gerçekleştiriyoruz.
		Set<String> brands = new HashSet<String>();
		brands.add("Honda");
		brands.add("Mazda");
		brands.add("Toyota");
		brands.add("Kia");
		brands.add("Audi");
		brands.add("Mercedes");
		brands.add("Ford");
		brands.add("Fiat");
		brands.add("Audi");
		brands.add("Ford");
		brands.add(null);
		
		System.out.println("Markalar");
		printAll(brands);
		// ********* HashSet Örneği *********
		
		
		// ********* Iterator Örneği *********
		// Iterator liste halinde veriler üzerinde tek tek dolaşabilmeyi ve eleman silmeyi sağlayan bir nesnedir.
		// Collection interface'den türemiş tüm alt sınıflarda .iterator() fonksiyonunu çağırarak elde edebilirsiniz.
		// Iterator oluşturulduktan sonra veri kümesine ekleme yapılamaz.
		// Bir döngü içinde dolaşıp bazı elemanları veri kümesinden silmek istersek bunun için Iterator kullanırız.
		System.out.println("Elemanlara erişmek için bir iterator nesnesi oluşturmak gerekiyor");
		
		// brands isimli Set tipindeki veri kümesinden Iterator nesnesi oluşturuyoruz.
		Iterator<String> iteratorObject = brands.iterator();
		
		// .next() fonksiyonu veri kümesindeki bir sonraki elemana erişmeyi sağlar.
		System.out.println(iteratorObject.next());
		System.out.println(iteratorObject.next());
		System.out.println(iteratorObject.next());
		
		// .hasNext() fonksiyonu ile listenin sonuna gelip gelmediğini kontrol eder.
		System.out.println(iteratorObject.hasNext());
		
		System.out.println("arta kalanlar");
		while(iteratorObject.hasNext()) 
		{
			System.out.println(iteratorObject.next());
		}
		// ********* Iterator Örneği *********
	}
	
	public static void runBookSample() {
		
		// ********* HashSet Örneği *********
		// Bu HashSet örneğinde Book tipinde kendi oluşturduğumuz sınıftan oluşan nesneleri tutan bir veri kümesi oluşturuyoruz.
		// Book sınıfındaki equals() ve hashCode() fonksiyonlarını override edip,
		// sınıf içindeki değişkenlerde tutulan verilerden hashcode üretilir.
		// Eğer tüm veriler aynı ise, oluşan hashcode'da aynı olacaktır. 
		// Hashcode'u aynı olan nesneler mükerrer olduğu için Set içinde sadece son eklenen tutulur.
		Book book1 = new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20);
		Book book2 = new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20);
		Book book3 = new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20);
		
		// hashcode'ları aynı olacaktır.
		System.out.println(book1.hashCode());
		System.out.println(book2.hashCode());
		System.out.println(book3.hashCode());
		
		
		Set<Book> books = new HashSet<Book>();
		books.add(new Book("Java Book", "Penguen Yayınevi", 2019, 500, 50));
		books.add(new Book("Python Book", "Panda Yayınevi", 2019, 250, 45.5));
		books.add(new Book("C# Book", "Elma Yayınevi", 2020, 660, 70));
		books.add(new Book("Ruby Book", "Beyaz Balina Yayınevi", 2019, 450, 28));
		books.add(new Book("Go Book", "Kanarya Yayınevi", 2017, 420, 80));
		
		// hashcode'u aynı olan nesneleri Set kümesine ekliyoruz, fakat mükerrer kayıt tutamaz!
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		System.out.println("Mükerrer eleman içermeyen kitap listesi");
		printAll(books);
		// ********* HashSet Örneği *********
	}
	
	
	public static void runTreeSetSamples() {
		
		// ********* TreeSet Örneği *********
		// Set kümesine eklenen elemanlar için insertion order tutulmaz, karışık sırada eklenir listeye.
		// Bu örnekte Long tipinde hazır bir veri tipi kullandık.
		// Long sınıfı 'Comparable' interface'den kalıtım aldığı için 'compareTo' fonksiyonunu override etmiş durumdadır.
		// Dolayısıyla TreeSet ile Long tipindeki veriler küçükten büyüğe doğru sıralanır.
		// TreeSet veri yapısı mükerrer kayıt tutmaz ve sıralı bir şekilde verileri tutar.
		Set<Long> yearSet = new TreeSet<Long>();
		yearSet.add(2019l);
		yearSet.add(2014l);
		yearSet.add(2020l);
		yearSet.add(2001l);
		yearSet.add(2017l);
		yearSet.add(2010l);
		yearSet.add(2009l);
		yearSet.add(2005l);
		
		System.out.println("Doğal bir şekilde sıralanmış TreeSet");
		printAll(yearSet);
		// ********* TreeSet Örneği *********
		
		// ********* TreeSet Örneği *********
		// Aynı yukarıdaki gibi TreeSet yapısını kullanarak Book tipindeki nesneleri sıralı bir şekilde tutuyoruz.
		// Book sınıfımız 'Comparable' interface'den kalıtım almaktadır. Dolayısıyla sınıf içinde 'compareTo' fonksiyonunu override ettik.
		// Kitapları A-Z olacak şekilde sıralı şekilde tutuyoruz
		Set<Book> books = new TreeSet<Book>();
		books.add(new Book("Java Book", "Penguen Yayınevi", 2019, 500, 50));
		books.add(new Book("Python Book", "Panda Yayınevi", 2019, 250, 45.5));
		books.add(new Book("C# Book", "Elma Yayınevi", 2020, 660, 70));
		books.add(new Book("Ruby Book", "Beyaz Balina Yayınevi", 2014, 450, 28));
		books.add(new Book("Go Book", "Kanarya Yayınevi", 2017, 420, 80));
		books.add(new Book("Javascript Book", "ABC Yayınevi", 2019, 300, 20));
		books.add(new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20));
		books.add(new Book("Javascript Book", "ABC Yayınevi", 2010, 300, 20));
		
		System.out.println("Doğal bir şekilde sıralanmış kitap listesi");
		printAll(books);
		// ********* TreeSet Örneği *********
		
		
		// ********* Comparator Örneği *********
		// Comparator interface'i ile elimizdeki veri kümesini farklı değişkenlere göre sıralayabiliriz.
		// TreeSet veri yapısına Comparator tipinden türemiş bir nesne vermezsek, 
		// TreeSet, Book sınıfındaki 'compareTo' fonksiyonuna bakarak sıralama yapar.
		// 'BookComparatorByPublisher' sınıfı 'Comparator' interface'den kalıtım almış bir alt sınıfdır.
		// Bu sıralama sınıfı kitapları yayıncı ismine göre A-Z şeklinde sıralamaktadır.
		BookComparatorByPublisher comparatorByPublisher = new BookComparatorByPublisher();
		Set<Book> sortedBooksByPublisher = new TreeSet<Book>(comparatorByPublisher);
		sortedBooksByPublisher.addAll(books);
		
		System.out.println("Yayınevi ismine göre sıralanmış kitap listesi");
		printAll(sortedBooksByPublisher);
		
		
		
		// Bu örnekte ise farklı bir Comparator tasarlayarak elimizdeki kitap listesini yayınlanma yılına göre sıralıyoruz.
		BookComparatorByPublishYear comparatorByPublisheryear = new BookComparatorByPublishYear();
		Set<Book> sortedBooksByPublishyear = new TreeSet<Book>(comparatorByPublisheryear);
		sortedBooksByPublishyear.addAll(sortedBooksByPublisher);
		
		System.out.println("Yayın yılı bilgisine göre sıralanmış kitap listesi");
		printAll(sortedBooksByPublishyear);
		// ********* Comparator Örneği *********
		
	}

	public static <T> void printAll(Set<T> set) {
		
		for(T item : set) {
			
			System.out.println(item);
		}
		System.out.println();
	}
}
