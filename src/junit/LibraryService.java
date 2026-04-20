package junit;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class LibraryService {

    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, List<Book>> userBorrowedBooks = new HashMap<>();

    public void addBook(int id, String title) {
        if (id <= 0) {
            throw new IllegalArgumentException("Book ID must be positive");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Book title cannot be null or empty");
        }
        if (books.containsKey(id)) {
            throw new IllegalArgumentException("Book ID must be unique");
        }
        books.put(id, new Book(id, title));
    }

    public void borrowBook(int userId, int bookId) {
        if (userId <= 0 || bookId <= 0) {
            throw new IllegalArgumentException("User ID must be positive");
        }

        Book book = books.get(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book is not available");
        }
        if (!book.isAvailable()) {
            throw new IllegalArgumentException("This book has been already borrowed");
        }
        List<Book> borrowed = userBorrowedBooks.getOrDefault(userId, new ArrayList<>());

        if (borrowed.size() >= 3) {
            throw new IllegalArgumentException("User cannot borrow more than 3 books");
        }
        if (borrowed.contains(book)) {
            throw new IllegalArgumentException("User already borrowed this book");
        }
        book.setAvailable(false);
        borrowed.add(book);
        userBorrowedBooks.put(userId, borrowed);
    }

    public void returnBook(int userId, int bookId) {
        if (userId <= 0 || bookId <= 0) {
            throw new IllegalArgumentException("Invalid IDs");
        }
        Book book = books.get(bookId);
        if (book == null) {
            throw new IllegalArgumentException("Book does not exist");
        }
        List<Book> borrowed = userBorrowedBooks.get(userId);

        if (borrowed == null || !borrowed.contains(book)) {
            throw new IllegalArgumentException("User did not borrow this book");
        }
        borrowed.remove(book);
        book.setAvailable(true);
    }

    public List<String> getAvailableBooks() {
        List<String> result = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.isAvailable()) {
                result.add(book.getTitle());
            }
        }
        return result;
    }

    public List<String> getBorrowedBooks(int userId) {
        if (userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        List<Book> borrowed = userBorrowedBooks.getOrDefault(userId, new ArrayList<>());
        List<String> result = new ArrayList<>();
        for (Book book : borrowed) {
            result.add(book.getTitle());
        }
        return result;
    }

    public void clear() {
        books.clear();
        userBorrowedBooks.clear();
    }
}

class Book {
    private int id;
    private String title;
    private boolean isAvailable;

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
