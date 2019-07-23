
public class Book {
	String title;
	String author;
	int ISBN;
	
	public Book(String title, String author, int ISBN) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		System.out.println("생성자1");
	}
	public Book(String title, int ISBN) {
		this(title,"Anonymous",ISBN);
		System.out.println("생성자2");
	}
	public Book() {
		this(null,null,0);
		System.out.println("생성자가 호출되었습니다.");
	}
	public static void main(String[] args) {
		Book javabook = new Book("JAVA JDK", "황기태",3333);
		Book holybible = new Book("holy bible", 3);
		Book emptybook = new Book();
	}

}
