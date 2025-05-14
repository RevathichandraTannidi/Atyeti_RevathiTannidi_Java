package library_book_Tracker;



public class Book {
    private static int totalBooks=0;
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
        totalBooks++;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public static int getTotalBooks() {
return totalBooks;
}


    public void issueBook() {
        this.isIssued=true;
    }
}
