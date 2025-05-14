package library_book_Tracker;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Book book1 = new Book("rani jyoshna", "Gl");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);

        library.displayBooks();
        library.issueBook("rani jyoshna");
        library.displayBooks();

        System.out.println("Total books created: " + Book.getTotalBooks());
    }
}
