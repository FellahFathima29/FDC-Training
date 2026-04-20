package junit;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Library Test")
public class LibraryServiceTest {
 static LibraryService service = new LibraryService();

    @BeforeAll
    public static void setup()
    {
    }
    @BeforeEach
    public void addBook()
    {
        service.addBook(1, "Wings of Fire");
        service.addBook(2, "Harry Potter");
    }

    @AfterEach
    public void clearDb()
    {
        service.clear();
    }

    @ParameterizedTest
    @CsvSource({
            "-1, 'Wings of Fire', 'Book ID must be positive'",
            "1, 'Wings of Fire', 'Book ID must be unique'",
            "1, 'Basics of Java', 'Book ID must be unique'",
    })

    public void testAddBook(int id, String title, String errorMessage) {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.addBook(id,title));
        assertEquals(errorMessage, e.getMessage());
    }

    @Test
    void testAddBookInvalidId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.addBook(-5, "Wings of Fire"));
        assertEquals("Book ID must be positive", e.getMessage());
    }

    @Test
    void testAddBookPositiveId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.addBook(1, "Wings of Fire"));
        assertEquals("Book ID must be unique", e.getMessage());
    }

    @Test
    void testAddBookDuplicateId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.addBook(1, "Basics of Java"));
        assertEquals("Book ID must be unique", e.getMessage());
    }

    @Test
    void testAddBookEmptyTitle() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.addBook(20, ""));
        assertEquals("Book title cannot be null or empty", e.getMessage());
    }

    @Test
    void testBorrowBookInvalidUserId() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.borrowBook(-8, 1));
        assertEquals("User ID must be positive", e.getMessage());
    }

    @Test
    void testBorrowBookMaxLimitExceeded() {
        service.addBook(3,"Basics of Java");
        service.addBook(4, "Basics of C++");
        service.borrowBook(100, 1);
        service.borrowBook(100, 2);
        service.borrowBook(100, 3);
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.borrowBook(100, 4));
        assertEquals("User cannot borrow more than 3 books", e.getMessage());
    }

    @Test
    void testBorrowBookSameBookTwice() {
        service.borrowBook(100, 1);
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.borrowBook(200, 1));
        assertEquals("This book has been already borrowed", e.getMessage());
    }

    @Test
    void testReturnBookNotBorrowed() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> service.returnBook(100, 1000));
        assertEquals("Book does not exist", e.getMessage());
    }


    @Test
    void testReturnBook() {
        service.borrowBook(100, 1);
        service.returnBook(100, 1);
        List<String> available = service.getAvailableBooks();
        assertEquals(2, available.size());
    }

    @Test
    void testGetBorrowedBooks() {
        service.borrowBook(100, 1);
        service.borrowBook(100, 2);
        List<String> borrowed = service.getBorrowedBooks(100);
        assertEquals(2, borrowed.size());
    }
}