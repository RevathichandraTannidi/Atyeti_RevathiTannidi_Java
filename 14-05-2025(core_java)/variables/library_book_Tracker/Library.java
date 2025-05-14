package library_book_Tracker;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void issueBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isIssued()) {
                book.issueBook();
                System.out.println("Book issued: " + title);
                return;
            }
        }
        System.out.println("Book not found or already issued: " + title);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() +
                    ", Is Issued: " + book.isIssued());
        }
    }

}

